package io.github.xfdzcoder.noj.cloud.sandbox.config;

import cn.hutool.core.util.StrUtil;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */
@SpringBootTest
public class DockerClientTest {

    private static final String IMAGE_NAME = "jre21";

    private static final String CODE = """
            import java.util.Scanner;
            public class Main {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    System.out.println(a + b);
                }
            }
            """;

    private static final String CONTAINER_ID = "34db8a28c214bce940a3da923c6da7baaf26338e458ac822b55c56203cf8b1d9";

    @Autowired
    private DockerClient dockerClient;

    @Test
    public void testConnect() {
        System.out.println(dockerClient.infoCmd().exec());
    }

    @Test
    public void testStartContainer() {
        /*
            stdIn:
                \n -> \r\n
                \r\n -> \r\n\r\n
         */

//        dockerClient.removeContainerCmd(CONTAINER_ID)
//                .exec();
        String containerId = dockerClient.createContainerCmd(IMAGE_NAME)
                .withName("test2")
                .withHostConfig(
                        HostConfig.newHostConfig()
                                .withNetworkMode("none")
                                .withMemory(1024L * 1024 * 256)
                                .withBinds(new Bind("/opt/tmp/java_test", new Volume("/sandbox")))
                )
                .withNetworkDisabled(true)
//                .withStdinOpen(Boolean.TRUE)
//                .withAttachStdin(Boolean.TRUE)
//                .withAttachStdout(Boolean.TRUE)
//                .withAttachStderr(Boolean.TRUE)
                .withCmd("tail", "-f", "/dev/null")
//                .withCmd("top")
                .exec()
                .getId();

        dockerClient.startContainerCmd(containerId)
                .exec();

        System.out.println(containerId);
        // 48358cecbc5963f35418a5ceea7cb1bb53101d62a7583dc878c9e1501b70b91d
    }

    @Test
    public void testExecCmd() throws InterruptedException {
        String execId = dockerClient.execCreateCmd(CONTAINER_ID)
                .withWorkingDir("/sandbox")
//                .withCmd("cd", "/sandbox")
//                .withCmd("sh", "-c", "(time -f \"%e %M %x\" java Main) 2>&1")
                .withCmd("time", "-f", "%e %M %x", "java", "Main")
//                .withCmd("time", "-v", "java", "-Xms64m", "Main")
//                .withCmd("echo", "Hello World")
                .withAttachStdin(Boolean.TRUE)
                .withAttachStdout(Boolean.TRUE)
                .withAttachStderr(Boolean.TRUE)
//                .withTty(Boolean.TRUE)
                .exec()
                .getId();

        String inputStr = "3 a\n";
        ByteArrayInputStream stdIn = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        ByteArrayOutputStream stdraw = new ByteArrayOutputStream();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
        dockerClient.execStartCmd(execId)
                .withStdIn(stdIn)
//                .withTty(Boolean.TRUE)
//                .withDetach(Boolean.TRUE)
                .exec(new ResultCallback.Adapter<>() {
                    @Override
                    public void onNext(Frame frame) {
                        try {
                            System.out.println(frame);
                            System.out.println("---------");
                            switch (frame.getStreamType()) {
                                case STDOUT -> stdout.write(frame.getPayload());
                                case STDERR -> stderr.write(frame.getPayload());
                            }
//                            out.write(frame.getPayload());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                })
                .awaitCompletion(4 * 1000, TimeUnit.MILLISECONDS);

        System.out.println(stdout.toString(StandardCharsets.UTF_8));
        System.out.println("----------------- ");
        System.out.println(stderr.toString(StandardCharsets.UTF_8));
        System.out.println("----------------- ");
        System.out.println(stdraw.toString(StandardCharsets.UTF_8));

//        String inputStrRN = StrUtil.replace(inputStr, "\n", "\r\n");
//
//        String[] output = getOutput(inputStrRN, out);
//        System.out.println(Arrays.toString(output));

    }

    private String[] getOutput(String input, ByteArrayOutputStream outStream) {
        String output = StrUtil.removePrefix(
                outStream.toString(StandardCharsets.UTF_8),
                input
        ).trim();
        int index = output.lastIndexOf("\r\n");
        String data = StrUtil.sub(output, 0, index);
        String[] info = StrUtil.subSuf(output, index + 2).split(" ");
        return new String[]{data, info[0], info[1], info[2]};
    }
}
