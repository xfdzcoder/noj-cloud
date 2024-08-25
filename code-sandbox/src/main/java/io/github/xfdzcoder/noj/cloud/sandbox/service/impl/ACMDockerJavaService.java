package io.github.xfdzcoder.noj.cloud.sandbox.service.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.bo.TestCase;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.service.AbstractDockerJavaExecutor;
import io.github.xfdzcoder.noj.cloud.sandbox.utils.compiler.ExitTypeEnum;
import io.github.xfdzcoder.noj.cloud.sandbox.exception.CompilerException;
import io.github.xfdzcoder.noj.cloud.sandbox.utils.compiler.StringSourceFileManager;
import io.github.xfdzcoder.noj.cloud.sandbox.utils.compiler.StringSourceFileObject;
import io.github.xfdzcoder.noj.cloud.sandbox.exception.ExecuteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ACMDockerJavaService extends AbstractDockerJavaExecutor {

    private static final JavaCompiler COMPILER = ToolProvider.getSystemJavaCompiler();

    private static final String WORKING_DIR = "/sandbox";

    private static final String CLASS_NAME = "Main";

    private static final String CLASS_FILE_NAME = CLASS_NAME + JavaFileObject.Kind.CLASS.extension;

    @Autowired
    private DockerClient dockerClient;

    @Override
    public ExecRes execute0(TestCase.InputOutput testCase, String execId, ExecuteInfo executeInfo) {
        String input = testCase.getInput().toString();

        ByteArrayInputStream stdIn = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        boolean finished = false;
        try {
            finished = dockerClient.execStartCmd(execId)
                    .withStdIn(stdIn)
//                    .withTty(Boolean.TRUE)
                    .exec(new ResultCallback.Adapter<>() {
                        @Override
                        public void onStart(Closeable stream) {
                            super.onStart(stream);
                        }

                        @Override
                        public void onNext(Frame frame) {
                            try {
                                switch (frame.getStreamType()) {
                                    case STDOUT -> stdout.write(frame.getPayload());
                                    case STDERR -> stderr.write(frame.getPayload());
                                }
                            } catch (IOException e) {
                                throw new ExecuteException(e);
                            }
                        }
                    })
                    .awaitCompletion(executeInfo.getTimeout(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // ignore
            log.warn(ExceptionUtil.stacktraceToOneLineString(e));
        }

        if (!finished) {
            throw new ExecuteException(
                    new ExecRes(
                            input, "超时错误，详细错误信息:\n" + stderr.toString(StandardCharsets.UTF_8),
                            0, 0, ExitTypeEnum.TIMEOUT
                    )
            );
        }

        String output = stdout.toString(StandardCharsets.UTF_8);
        String errOutput = stderr.toString(StandardCharsets.UTF_8).trim();
        if (StrUtil.isBlank(errOutput)) {
            throw new ExecuteException("容器异常: \n" + output);
        }


        int index = errOutput.lastIndexOf("\r\n");
        String errInfo;
        String[] execInfo;
        if (index < 0) {
            errInfo = "执行成功";
            execInfo = errOutput.split(" ");
        } else {
            errInfo = StrUtil.sub(errOutput, 0, index);
            execInfo = StrUtil.subSuf(errOutput, index + 2).split(" ");
        }


        boolean hasError = ! "0".equals(execInfo[2]);

        ExecRes execRes = new ExecRes(
                execInfo,
                hasError ? errInfo : output,
                (int) (NumberUtil.parseDouble(execInfo[0]) * 1000D),
                Integer.parseInt(execInfo[1]),
                hasError ? ExitTypeEnum.RUN_ERROR : ExitTypeEnum.NORMAL
        );
        if (hasError) {
            throw new ExecuteException(execRes);
        }
        return execRes;
    }

    public String createExec(ExecuteInfo executeInfo, String containerId) {
        return dockerClient.execCreateCmd(containerId)
                .withWorkingDir(WORKING_DIR)
//                .withCmd("time", "-f", "%e %M %x", "java", "-Xmx " + executeInfo.getMemory(), "Main")
                .withCmd("time", "-f", "%e %M %x", "java", "Main")
                .withAttachStdin(Boolean.TRUE)
                .withAttachStdout(Boolean.TRUE)
                .withAttachStderr(Boolean.TRUE)
                .exec()
                .getId();
    }

    public File compileCode(String codeText, String classDir) throws CompilerException {

        File classDirFile = null;
        String classFilePath = classDir + CLASS_FILE_NAME;
        try {
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

            StringSourceFileObject fileObject = new StringSourceFileObject(CLASS_NAME, codeText);
            String classpath = System.getProperty("java.home") + "\\lib\\modules";
            JavaCompiler.CompilationTask task = COMPILER.getTask(
                    null,
                    new StringSourceFileManager(),
                    diagnostics,
                    List.of("-proc:none", "-classpath", classpath),
                    null,
                    Collections.singleton(fileObject)
            );

            if (!task.call()) {
                List<Diagnostic<? extends JavaFileObject>> diagnosticList = diagnostics.getDiagnostics();
                String errorMessage = diagnosticList.stream().map(Object::toString).collect(Collectors.joining("\n"));
                throw new CompilerException(errorMessage);
            }
            // 保存到文件

            classDirFile = new File(classDir);
            if (FileUtil.exist(classDirFile)) {
                boolean deleted = FileUtil.del(classDirFile);
                log.warn("执行前发现重复文件夹: {}，已删除 {}", classDir, deleted ? "成功" : "失败");
            }
            FileUtil.mkdir(classDirFile);
            if (!FileUtil.exist(classDirFile)) {
                log.error("{} 创建失败", classDir);
                throw new CompilerException("系统异常");
            }

            FileUtil.writeBytes(fileObject.getByteCode(), classFilePath);

            return classDirFile;
        } catch (IOException e) {
            throw new CompilerException(e);
        } finally {
            if (FileUtil.exist(classFilePath)) {
                log.info("编译成功，class 文件路径: {}", classFilePath);
            } else {
                log.info("编译失败，classDir: {}", classDir);
            }
        }
    }

    public String createAndStartContainer(ExecuteInfo executeInfo, String classDir) {
        String containerId = dockerClient.createContainerCmd("jre21")
                .withName("sandbox_java_" + executeInfo.getId())
                .withHostConfig(
                        HostConfig.newHostConfig()
                                .withNetworkMode("none")
                                .withAutoRemove(true)
                                // 单位 Byte
                                .withMemory((long) executeInfo.getMemory())
                                .withBinds(new Bind(classDir, new Volume("/sandbox")))
                                .withCpuShares(1024)
                )
                .withNetworkDisabled(true)
                .withCmd("tail", "-f", "/dev/null")
                .exec()
                .getId();

        dockerClient.startContainerCmd(containerId).exec();
        return containerId;
    }

    public boolean compareOutput(Object output, Object expectedOutput) {
        return output.equals(expectedOutput);
    }

}
