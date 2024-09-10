package io.github.xfdzcoder.noj.cloud.mini.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MiniCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCommunityApplication.class, args);
    }

}
