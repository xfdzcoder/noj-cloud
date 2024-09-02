package io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.impl;

import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.StringRedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xfdzcoder
 */

@Component
public class DefaultRedisOperator implements RedisOperator {

    @Autowired
    private StringRedisOperator stringRedisOperator;

    @Override
    public StringRedisOperator opsStr() {
        return stringRedisOperator;
    }
}
