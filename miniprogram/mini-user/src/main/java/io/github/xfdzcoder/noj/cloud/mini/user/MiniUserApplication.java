package io.github.xfdzcoder.noj.cloud.mini.user;

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
public class MiniUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniUserApplication.class, args);
    }

}
