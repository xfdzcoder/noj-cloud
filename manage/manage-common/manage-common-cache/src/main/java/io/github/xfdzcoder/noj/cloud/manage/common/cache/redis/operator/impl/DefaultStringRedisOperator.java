package io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.stream.StreamUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.StringRedisOperator;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.bo.StringRedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认的 {@link StringRedisOperator} 实现
 *
 * @author Ding
 */

@Component
public class DefaultStringRedisOperator implements StringRedisOperator {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * {@inheritDoc}
     *
     * @param stringRedisCache 需要被缓存的缓存对象
     * @param <V>
     */
    @Override
    public <V> void set(StringRedisCache<V> stringRedisCache) {
        if (ObjUtil.isNull(stringRedisCache.getTimeout()) || ObjUtil.isNull(stringRedisCache.getTimeUnit())) {
            stringRedisTemplate.opsForValue().set(stringRedisCache.getCacheKey(), stringRedisCache.getValueAndSet());
        } else {
            stringRedisTemplate.opsForValue().set(stringRedisCache.getCacheKey(), stringRedisCache.getValueAndSet(), stringRedisCache.getTimeout(), stringRedisCache.getTimeUnit());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param cacheList 需要被缓存的集合
     * @param <T>
     * @param <V>
     */
    @Override
    public <T extends StringRedisCache<V>, V> void setBatch(Iterable<T> cacheList) {
        if (ObjectUtil.isEmpty(cacheList)) {
            return;
        }
        // 管道操作，提高效率
        stringRedisTemplate.executePipelined(new SessionCallback<Object>() {

            @Override
            @Nullable
            public <K, V1> Object execute(@NonNull RedisOperations<K, V1> operations) throws DataAccessException {
                @SuppressWarnings("unchecked")
                RedisOperations<String, String> stringRedisOperations = (RedisOperations<String, String>) operations;
                for (StringRedisCache<V> template : cacheList) {
                    if (template.getTimeUnit() != null && template.getTimeout() != null) {
                        stringRedisOperations.opsForValue().set(template.getCacheKey(), template.getValueAndSet(), template.getTimeout(), template.getTimeUnit());
                    } else {
                        stringRedisOperations.opsForValue().set(template.getCacheKey(), template.getValueAndSet());
                    }
                }
                // NOTE: 此方法必须返回 null，否则将抛出异常 !!!
                return null;
            }
        });
    }

    /**
     * {@inheritDoc}
     *
     * @param stringRedisCache 缓存对象，可以只提供键，值获取出来后会填充到对象中
     * @param <V>
     * @return
     */
    @Override
    public <V> String getString(StringRedisCache<V> stringRedisCache) {
        String value = stringRedisTemplate.opsForValue().get(stringRedisCache.getCacheKey());
        stringRedisCache.setValue(value);
        return value;
    }

    /**
     * {@inheritDoc}
     *
     * @param stringRedisCache 缓存对象，可以只提供键，值获取出来后会填充到对象中
     * @param <V>
     * @return
     */
    @Override
    public <V> V getBean(StringRedisCache<V> stringRedisCache) {
        getString(stringRedisCache);
        return stringRedisCache.getBeanAndSet();
    }

    /**
     * {@inheritDoc}
     *
     * @param cacheList 需要批量查询的键集合
     * @param <T>
     * @param <V>
     * @return
     */
    @Override
    public <T extends StringRedisCache<V>, V> List<String> listString(Iterable<T> cacheList) {
        if (CollUtil.isEmpty(cacheList)) {
            return CollUtil.empty(String.class);
        }
        List<String> keyList = StreamUtil.of(cacheList)
                .map(StringRedisCache::getCacheKey)
                .collect(Collectors.toList());
        List<String> valueList = stringRedisTemplate.opsForValue().multiGet(keyList);
        if (CollUtil.isEmpty(valueList)) {
            return CollUtil.empty(String.class);
        }
        Iterator<T> cacheIterator = cacheList.iterator();
        for (int i = 0; i < valueList.size() && cacheIterator.hasNext(); i++) {
            String value = valueList.get(i);
            T cache = cacheIterator.next();
            cache.setValue(value);
        }
        return valueList;
    }

    /**
     * {@inheritDoc}
     *
     * @param cacheList 需要批量查询的键集合
     * @param <T>
     * @param <V>
     * @return
     */
    @Override
    public <T extends StringRedisCache<V>, V> List<V> listBean(Iterable<T> cacheList) {
        listString(cacheList);
        Iterator<T> cacheIterator = cacheList.iterator();
        List<V> result = new LinkedList<>();
        while (cacheIterator.hasNext()) {
            T cache = cacheIterator.next();
            result.add(cache.getBeanAndSet());
        }
        return result;
    }
}
