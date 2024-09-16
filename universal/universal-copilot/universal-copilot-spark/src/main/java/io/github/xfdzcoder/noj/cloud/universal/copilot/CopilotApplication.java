package io.github.xfdzcoder.noj.cloud.universal.copilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@SpringBootApplication
@EnableDiscoveryClient
public class CopilotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CopilotApplication.class, args);
    }

}
