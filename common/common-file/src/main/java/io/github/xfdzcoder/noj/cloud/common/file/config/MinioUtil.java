package io.github.xfdzcoder.noj.cloud.common.file.config;

import cn.hutool.core.util.StrUtil;
import io.github.xfdzcoder.noj.cloud.common.cache.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.common.file.config.redis.PresignedUrlCache;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Autowired
    private RedisOperator redisOperator;

    public String getPresignedObjectUrl(String key, Integer timeout, TimeUnit timeUnit) {
        String url = redisOperator.opsStr().getBean(new PresignedUrlCache(key));
        if (StrUtil.isBlank(url)) {
            GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                                                                      .expiry(timeout, timeUnit)
                                                                      .method(Method.GET)
                                                                      .region(minioProperties.getRegion())
                                                                      .bucket(minioProperties.getBucket())
                                                                      .object(key)
                                                                      .build();

            try {
                 url = minioClient.getPresignedObjectUrl(args);
                 redisOperator.opsStr().set(new PresignedUrlCache(key, url));
                return url;
            } catch (Exception e) {
                throw new MinioException(e);
            }
        }
        return url;
    }

    public List<String> getPresignedObjectUrl(List<String> keyList, Integer timeout, TimeUnit timeUnit) {
        return keyList.stream().map(key -> getPresignedObjectUrl(key, timeout, timeUnit)).toList();
    }
}
