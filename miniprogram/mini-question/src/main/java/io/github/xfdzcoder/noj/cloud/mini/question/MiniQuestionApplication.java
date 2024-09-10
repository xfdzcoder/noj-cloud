package io.github.xfdzcoder.noj.cloud.mini.question;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@EnableDubbo
@SpringBootApplication
@EnableDiscoveryClient
public class MiniQuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniQuestionApplication.class, args);
    }

}
