package io.github.xfdzcoder.noj.cloud.mini.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MiniUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniUserApplication.class, args);
    }

}
