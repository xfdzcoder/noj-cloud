package io.github.xfdzcoder.noj.cloud.manage.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@EnableDiscoveryClient
@SpringBootApplication
public class CodeSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSandboxApplication.class, args);
    }

}
