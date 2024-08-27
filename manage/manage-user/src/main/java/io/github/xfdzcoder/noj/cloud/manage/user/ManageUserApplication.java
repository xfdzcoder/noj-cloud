package io.github.xfdzcoder.noj.cloud.manage.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfdzcoder
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ManageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageUserApplication.class, args);
    }

}
