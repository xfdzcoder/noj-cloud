package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import com.github.dockerjava.api.DockerClient;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.config.DockerJavaProperties;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.exception.CompilerException;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.exception.ExecuteException;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExitTypeEnum;
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
    protected DockerClient dockerClient;

    @Override
    public ExecuteResp execute(ExecuteReq executeReq, List<TestCase> testCases) {
        ExecuteResp result = new ExecuteResp();
        int totalExecutionTime = 0;
        int totalMemoryUsed = 0;
        int passedCaseCount = 0;

        String classDir = StrFormatter.format(dockerJavaProperties.getBaseDirectoryFormat(), executeReq.getId());
        File classDirFile = null;
        String containerId = null;

        try {

            // 编译代码并将其保存到 classDir 中
            try {
                classDirFile = compileCode(executeReq.getCodeText(), classDir);
            } catch (CompilerException e) {
                result.setExitType(ExitTypeEnum.COMPILE_ERROR);
                result.setThrowableOutput(e.getMessage());
                return result;
            }

            // 创建并启动 Docker 容器
            containerId = createAndStartContainer(executeReq, classDir);

//            List<TestCase.InputOutput> testCaseList = testCases.getContent();


            for (TestCase testCase : testCases) {

                String execId = createExec(executeReq, containerId);
                ExecRes execRes = execute0(testCase, execId, executeReq);

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
                    result.setExitType(ExitTypeEnum.RUN_ERROR);
                    break;
                }
            }

            // 填充结果
            int totalTestCase = testCases.size();

            result.setExecuteInfoId(executeReq.getId());
            result.setSucceed(passedCaseCount == totalTestCase);
            result.setAvgTime(totalExecutionTime / totalTestCase);
            result.setAvgMemory(totalMemoryUsed / totalTestCase);
            result.setPassedCaseCount(passedCaseCount);
            result.setTotalCaseCount(totalTestCase);
            if (result.getSucceed() && ObjUtil.isNull(result.getExitType())) {
                result.setExitType(ExitTypeEnum.NORMAL);
            }

            return result;
        } catch (Exception e) {
            if (e instanceof ExecuteException execException) {
                ExecRes execRes = execException.getExecRes();
                result.setInput(execRes.input());
                result.setOutput(execRes.output());
                result.setAvgTime(execRes.time());
                result.setAvgMemory(execRes.memory());
                result.setExitType(execRes.type());
                log.error("容器内部异常: \n{}", JSONUtil.toJsonPrettyStr(result));
            }
            log.error(ExceptionUtil.stacktraceToString(e));
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

    protected abstract String createAndStartContainer(ExecuteReq executeReq, String classDir);

    protected abstract String createExec(ExecuteReq executeReq, String containerId);

    protected abstract ExecRes execute0(TestCase testCase, String execId, ExecuteReq executeReq);

    protected abstract boolean compareOutput(Object output, Object exceptedOutput);
}
