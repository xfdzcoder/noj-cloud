package io.github.xfdzcoder.noj.cloud.common.file.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xfdzcoder
 */

@Configuration
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    @ConditionalOnProperty(MinioProperties.PREFIX + ".endpoint")
    public MinioClient minioClient() {
        return MinioClient.builder()
                          .endpoint(minioProperties.getEndpoint())
                          .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                          .region(minioProperties.getRegion())
                          .build();
    }

}
