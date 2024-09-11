package io.github.xfdzcoder.noj.cloud.sandbox.service;

import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.UniversalCodeSandboxApplication;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.DockerJavaExecutor;
//import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.ExecuteInfoService;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xfdzcoder
 */

@SpringBootTest(classes = UniversalCodeSandboxApplication.class)
public class DockerJavaExecutorTest {

    @Autowired
    private DockerJavaExecutor dockerJavaExecutor;

    @Test
    public void initData() {
        String code = """
                import java.util.Scanner;
                public class Main {
                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        System.out.println(a + b);
//                        int c = scanner.nextInt();
//                        int d = scanner.nextInt();
//                        System.out.println("c + d = " + (c + d));
                    }
                }
                """;
//        byte[] codeBytes = code.getBytes(StandardCharsets.UTF_8);
//        ExecuteReq executeInfo = ExecuteReq.builder()
//                .size(codeBytes.length)
//                .codeText(code)
//                .languageType("Java")
//                .memory(131072)
//                .timeout(2000)
//                .questionInfoId(1L)
//                .runType(0)
//                .build();
//        executeInfoService.save(executeInfo);
//        TestCase testCase = TestCase.builder()
//                .questionInfoId(1L)
//                .content(List.of(
//                        new TestCase.InputOutput("1 2\n", "3"),
//                        new TestCase.InputOutput("4 5\n", "9")
//                ))
//                .build();
//        testCaseService.save(testCase);
//
//        executeInfo.setTestCaseId(testCase.getId());
//        executeInfoService.updateById(executeInfo);
    }

    @Test
    public void selectJson() {
//        TestCase testCase = testCaseService.getById(1825816391371419650L);
//        System.out.println(testCase);
    }

    @Test
    public void testExecute() {
//        ExecuteReq executeInfo = executeInfoService.getById(1L);
        ExecuteReq req = new ExecuteReq();
        req.setId(1L);
        req.setCodeText("""
                import java.util.Scanner;
                public class Main {
                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        System.out.println(a + b);
                    }
                }
                """);
        req.setSize(288);
        req.setMemory(134217728);
        req.setTimeout(2000);
        req.setLanguageType("Java");
        req.setRunType(0);
        req.setQuestionInfoId(1829045838811627522L);
        TestCase aCase = new TestCase();
        aCase.setQuestionInfoId(1829045838811627522L);
        aCase.setInput("1 2\n");
        aCase.setOutput("3\n");

        ExecuteResp executeResult = dockerJavaExecutor.execute(req, List.of(
                aCase
        ));

        System.out.println(executeResult);
    }

}
