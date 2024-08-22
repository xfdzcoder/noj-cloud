package io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra;

import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.config.SparkProperties;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpRequest;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpResponse;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.service.SparkService;
import jakarta.annotation.PostConstruct;
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
        System.out.println(sparkService.ask("谈谈你对美剧《无耻之徒》的看法"));
    }

}
