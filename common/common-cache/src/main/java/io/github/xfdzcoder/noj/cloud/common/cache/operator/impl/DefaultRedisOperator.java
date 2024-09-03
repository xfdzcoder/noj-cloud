package io.github.xfdzcoder.noj.cloud.common.cache.operator.impl;

import io.github.xfdzcoder.noj.cloud.common.cache.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.common.cache.operator.StringRedisOperator;
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
