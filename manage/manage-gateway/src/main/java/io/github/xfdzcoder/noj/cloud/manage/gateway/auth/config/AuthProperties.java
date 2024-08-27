package io.github.xfdzcoder.noj.cloud.manage.gateway.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

    private List<String> excludePaths;

}
