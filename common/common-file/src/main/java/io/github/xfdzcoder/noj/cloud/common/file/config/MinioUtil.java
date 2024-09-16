package io.github.xfdzcoder.noj.cloud.common.file.config;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */

@Slf4j
@Component
@ConditionalOnBean(MinioClient.class)
public class MinioUtil {

    @Autowired
    private MinioProperties minioProperties;

    @Autowired
    private MinioClient minioClient;

    public String getPresignedObjectUrl(String key) {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                                                                  .expiry(1, TimeUnit.DAYS)
                                                                  .method(Method.GET)
                                                                  .region(minioProperties.getRegion())
                                                                  .bucket(minioProperties.getBucket())
                                                                  .object(key)
                                                                  .build();

        try {
            return minioClient.getPresignedObjectUrl(args);
        } catch (Exception e) {
            throw new MinioException(e);
        }
    }

}
