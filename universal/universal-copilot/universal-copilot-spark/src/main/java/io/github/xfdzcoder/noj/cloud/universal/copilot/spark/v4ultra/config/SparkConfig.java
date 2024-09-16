package io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

/**
 * @author xfdzcoder
 */

@Configuration
public class SparkConfig {

    @Bean("SparkHttpRestClient")
    public RestClient sparkHttpRestClient(SparkProperties sparkProperties) {
        return RestClient.builder()
                         .baseUrl(sparkProperties.getHttpUrl())
                         .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                         .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + sparkProperties.getApiPassword())
                         .build();
    }

}
