package io.github.xfdzcoder.noj.cloud.sandbox.service;

import io.github.xfdzcoder.noj.cloud.sandbox.CodeSandboxApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xfdzcoder
 */

@SpringBootTest(classes = CodeSandboxApplication.class)
public class DockerJavaExecutorTest {

    @Autowired
    private DockerJavaExecutor dockerJavaExecutor;

    @Autowired
    private ExecuteInfoService executeInfoService;

    @Test
    public void initData() {
        String code = """
                import java.util.Scanner;
                public class Main {
                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        System.out.println("a + b = " + (a + b));
                        int c = scanner.nextInt();
                        int d = scanner.nextInt();
                        System.out.println("c + d = " + (c + d));
                    }
                }
                """;
//        byte[] codeBytes = code.getBytes(StandardCharsets.UTF_8);
//        ExecuteInfo executeInfo = ExecuteInfo.builder()
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
//        ExecuteInfo executeInfo = executeInfoService.getById(1825816388385075201L);
//        ExecuteResult executeResult = dockerJavaExecutor.execute(executeInfo);
//
//        System.out.println(executeResult);
    }

}
