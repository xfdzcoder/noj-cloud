package io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra;

import io.github.xfdzcoder.noj.cloud.universal.copilot.api.SparkService;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeReq;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xfdzcoder
 */

@SpringBootTest
public class CodeOptimizeTest {

    @Autowired
    private SparkService sparkService;

    @Test
    public void test() {
        CodeOptimizeReq req = new CodeOptimizeReq();
        req.setCodeText("""
                import java.util.Scanner;
                public class Main {
                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        System.out.println(a + b + 1);
                    }
                }""");
        req.setQuestionTitle("计算两个数的和");
        req.setQuestionDescription("编写一个Java程序，输入两个整数，输出它们的和");
        req.setErrorMessage("运行错误");
        sparkService.codeOptimize(req)
                            .whenComplete((resp, ex) -> {
                                System.out.println(resp);
                            });
    }

}
