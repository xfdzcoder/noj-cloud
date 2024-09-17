package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author xfdzcoder
 */

@Data
@Component
@RefreshScope
@ConfigurationProperties("docker.java")
public class DockerJavaProperties {

    private String baseDirectoryFormat = "/tmp/sandbox/java_{}/";

}
