package io.github.xfdzcoder.noj.cloud.manage.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ManageCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCommunityApplication.class, args);
    }

}
