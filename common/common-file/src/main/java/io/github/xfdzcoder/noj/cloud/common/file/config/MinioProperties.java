package io.github.xfdzcoder.noj.cloud.common.file.config;

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
@ConfigurationProperties(prefix = MinioProperties.PREFIX)
public class MinioProperties {

    public static final String PREFIX = "noj.file.minio";

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String region;

}
