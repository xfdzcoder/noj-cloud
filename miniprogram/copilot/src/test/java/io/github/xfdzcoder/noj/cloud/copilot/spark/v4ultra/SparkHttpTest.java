package io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra;

import cn.hutool.core.text.StrFormatter;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra.config.SparkProperties;
import io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra.dto.SparkHttpRequest;
import io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra.dto.SparkHttpResponse;
import io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra.service.SparkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Objects;

/**
 * @author xfdzcoder
 */

@SpringBootTest
public class SparkHttpTest {

    @Autowired
    private SparkProperties sparkProperties;

    @Test
    public void testHttp() {
        SparkHttpResponse response = RestClient.create(sparkProperties.getHttpUrl())
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + sparkProperties.getApiPassword())
                .body(
                        SparkHttpRequest.builder(sparkProperties)
                                .message("来个只有程序员能听懂的笑话")
                                .build()
                )
                .exchange((httpRequest, httpResponse) -> Objects.requireNonNull(httpResponse.bodyTo(SparkHttpResponse.class)));

        System.out.println(JSONUtil.toJsonPrettyStr(response));
    }

    @Autowired
    private SparkService sparkService;

    @Test
    public void testSparkService() {
        System.out.println(sparkService.ask("一句话谈谈你对美剧《无耻之徒》的看法"));
    }

    @Test
    public void testScore() {
        String question = "“a==b”和”a.equals(b)”有什么区别？";
        String trueAnswer = "如果 a 和 b 都是对象，则 a==b 是比较两个对象的引用，只有当 a 和 b 指向的是堆中的同一个对象才会返回 true，而 a.equals(b) 是进行逻辑比较，所以通常需要重写该方法来提供逻辑一致性的比较。例如，String 类重写 equals() 方法，所以可以用于两个不同对象，但是包含的字母相同的比较。";
        String answer = "a==b是比较的地址，a.equals(b)比较的是内容。而且可以通过重写 Object 的 equals 方法来自定义“两个对象相同”时的逻辑。";

        Integer score;
        String comment;

        String resp = sparkService.ask(StrFormatter.format("""
                你现在是一个阅卷老师，我会给你一个答案和问题，你需要对其答案进行理解并根据参考答案评分以及点评，评分标准包括：答案正确性、完整性、扩展性。满分100分。
                下面的三个代码块分别是：问题、答案、参考答案。
                ```
                {}
                ```
                ```
                {}
                ```
                ```
                {}
                ```
                你的回答仅仅包含JSON字符串，除了JSON字符串外没有任何说明语、提示语、代码块等等，并且需要以严格的JSON格式回复，JSON对象的格式如下。
                {
                    "score": 5,
                    "comment": ""
                }
                其中，score 属性是你的评分，comment 属性是你对答案的点评，例如答案的遗漏点、错误点等等。相较于参考答案没有遗漏或错误则可以适当鼓励。
                """,
                question, answer, trueAnswer));
        System.out.println(resp);

        JSON json = JSONUtil.parse(resp);
        score = json.getByPath("score", Integer.class);
        comment = json.getByPath("comment", String.class);

        System.out.println("score = " + score);
        System.out.println("comment = " + comment);
    }
}
