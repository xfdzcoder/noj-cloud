package io.github.xfdzcoder.noj.cloud.mini.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "mini.auth")
public class AuthProperties {

    private List<String> excludePaths;

}
