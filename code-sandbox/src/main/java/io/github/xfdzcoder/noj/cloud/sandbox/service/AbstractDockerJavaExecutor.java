package io.github.xfdzcoder.noj.cloud.sandbox.service;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrFormatter;
import com.github.dockerjava.api.DockerClient;
import io.github.xfdzcoder.noj.cloud.sandbox.config.DockerJavaProperties;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.sandbox.exception.ExecuteException;
import io.github.xfdzcoder.noj.framework.sandbox.java.ExitTypeEnum;
import io.github.xfdzcoder.noj.framework.sandbox.java.complier.CompilerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * @author xfdzcoder
 */

public abstract class AbstractDockerJavaExecutor implements DockerJavaExecutor {

    private static final Logger log = LoggerFactory.getLogger(AbstractDockerJavaExecutor.class);
    @Autowired
    protected DockerJavaProperties dockerJavaProperties;

    @Autowired
    protected TestCaseService testCaseService;

    @Autowired
    protected DockerClient dockerClient;

    @Override
    public ExecuteResult execute(ExecuteInfo executeInfo) {
        ExecuteResult result = new ExecuteResult();
        int totalExecutionTime = 0;
        int totalMemoryUsed = 0;
        int passedCaseCount = 0;

        String classDir = StrFormatter.format(dockerJavaProperties.getBaseDirectoryFormat(), executeInfo.getId());
        File classDirFile = null;
        String containerId = null;

        try {

            // 编译代码并将其保存到 classDir 中
            try {
                classDirFile = compileCode(executeInfo.getCodeText(), classDir);
            } catch (CompilerException e) {
                result.setExitType(ExitTypeEnum.COMPILE_ERROR.getCode());
                result.setThrowableOutput(e.getMessage());
                return result;
            }

            // 创建并启动 Docker 容器
            containerId = createAndStartContainer(executeInfo, classDir);

            List<TestCase.InputOutput> testCaseList = testCaseService.getByQuestionInfoId(executeInfo.getQuestionInfoId())
                    .getContent();


            for (TestCase.InputOutput testCase : testCaseList) {

                String execId = createExec(executeInfo, containerId);
                ExecRes execRes = execute0(testCase, execId, executeInfo);

                // 在这里，实现逻辑来比较 execOutput 和 testCase.getExpectedOutput（）
                boolean outputPassed = compareOutput(execRes.output(), testCase.getOutput());

                if (outputPassed) {
                    passedCaseCount++;

                    totalExecutionTime += execRes.time();
                    totalMemoryUsed += execRes.memory();

                } else {
                    result.setInput(testCase.getInput());
                    result.setOutput(execRes.output());
                    result.setExceptOutput(testCase.getOutput());
                    result.setExitType(ExitTypeEnum.RUN_ERROR.getCode());
                    break;
                }
            }

            // 填充结果
            int totalTestCase = testCaseList.size();

            result.setExecuteInfoId(executeInfo.getId());
            result.setSucceed(passedCaseCount == totalTestCase);
            result.setAvgTime(totalExecutionTime / totalTestCase);
            result.setAvgMemory(totalMemoryUsed / totalTestCase);
            result.setPassedCaseCount(passedCaseCount);
            result.setTotalCaseCount(totalTestCase);

            return result;
        } catch (Exception e) {
            if (e instanceof ExecuteException execException) {
                log.error("容器内部异常: \n{}", execException.getExecRes().output());
            }
            log.error(ExceptionUtil.stacktraceToString(e));
            result.setExitType(ExitTypeEnum.RUN_ERROR.getCode());
            return result;

        } finally {
            if (classDirFile != null) {
                String file = classDirFile.getAbsolutePath();
                log.info("执行结束，删除文件: {}", file);
                boolean deleted = FileUtil.del(classDirFile);
                log.info("{} 删除 {}", file, deleted ? "成功" : "失败");
            }
            if (containerId != null) {
                // 清理：停止并移除容器
                dockerClient.removeContainerCmd(containerId)
                        .withForce(true)
                        .exec();
            }
        }
    }

    protected abstract File compileCode(String code, String classDir) throws CompilerException;

    protected abstract String createAndStartContainer(ExecuteInfo executeInfo, String classDir);

    protected abstract String createExec(ExecuteInfo executeInfo, String containerId);

    protected abstract ExecRes execute0(TestCase.InputOutput testCase, String execId, ExecuteInfo executeInfo);

    protected abstract boolean compareOutput(Object output, Object exceptedOutput);
}
