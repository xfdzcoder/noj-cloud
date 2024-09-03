package io.github.xfdzcoder.noj.cloud.mini.copilot.spark.v4ultra.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xfdzcoder
 */

@Data
@Component
@ConfigurationProperties("ai.spark")
public class SparkProperties {

    private String apiId;

    private String apiSecret;

    private String apiKey;

    private String apiPassword;

    private Model model;

    private String httpUrl;

    private String wssUrl;

    @Getter
    public enum Model {

        FOUR_ULTRA("4.0Ultra"),

        GENERAL_3_5("generalv3.5"),

        PRO_128K("pro-128k"),

        GENERAL_3("generalv3"),

        GENERAL("general");

        private final String name;

        Model(String name) {
            this.name = name;
        }
    }

}
