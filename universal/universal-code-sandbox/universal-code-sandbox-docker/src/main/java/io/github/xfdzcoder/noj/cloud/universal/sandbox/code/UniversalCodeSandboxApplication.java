package io.github.xfdzcoder.noj.cloud.universal.sandbox.code;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class UniversalCodeSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversalCodeSandboxApplication.class, args);
    }

}
