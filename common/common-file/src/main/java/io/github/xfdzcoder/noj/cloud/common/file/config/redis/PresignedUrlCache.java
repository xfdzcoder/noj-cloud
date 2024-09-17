package io.github.xfdzcoder.noj.cloud.common.file.config.redis;

import io.github.xfdzcoder.noj.cloud.common.cache.bo.AbstractStringRedisCache;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */

public class PresignedUrlCache extends AbstractStringRedisCache<String> {

    public PresignedUrlCache(String key) {
        super(key);
    }

    public PresignedUrlCache(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public String getKeyPattern() {
        return "minio:presigned:" + this.key;
    }

    @Override
    public String doGetBean(@NonNull String value) {
        return value;
    }

    @Override
    public String doGetValue(@NonNull String bean) {
        return bean;
    }

    @Override
    public Long getTimeout() {
        return 1L;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.DAYS;
    }
}
