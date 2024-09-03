package io.github.xfdzcoder.noj.cloud.common.cache.bo;

import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import io.github.xfdzcoder.noj.cloud.common.cache.exception.RedisException;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * {@link StringRedisCache} 的抽象实现，为 {@link #getTimeout()} 和 {@link #getTimeUnit()} 提供了默认实现
 *
 * @param <V> 缓存中存储数据的类型
 * @author Ding
 */


@Data
public abstract class AbstractStringRedisCache<V> implements StringRedisCache<V> {

    protected String key;

    protected String value;

    protected V bean;

    protected Long timeout;

    protected TimeUnit timeUnit;

    public AbstractStringRedisCache() {
    }

    public AbstractStringRedisCache(String key) {
        this.key = key;
    }

    public AbstractStringRedisCache(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public AbstractStringRedisCache(String key, V bean) {
        this.key = key;
        this.bean = bean;
    }

    public AbstractStringRedisCache(String key, V bean, Long timeout, TimeUnit timeUnit) {
        this.key = key;
        this.bean = bean;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    public AbstractStringRedisCache(String key, String value, Long timeout, TimeUnit timeUnit) {
        this.key = key;
        this.value = value;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getCacheKey() {
        return StrFormatter.format(getKeyPattern(), getKey());
    }

    /**
     * @return Key 的模板字符串
     */
    public abstract String getKeyPattern();

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public V getBeanAndSet() {
        if (ObjUtil.isNull(this.bean)) {
            if (StrUtil.isBlank(this.value)) {
                throw new RedisException("异常操作，value 和 bean 都为空");
            }
            V bean = doGetBean(value);
            setBeanAndValue(bean, value);
        }
        return bean;
    }

    /**
     * 将 bean 和 value 进行存储
     *
     * @param bean  缓存值对应的 bean 对象
     * @param value value 缓存值
     */
    protected void setBeanAndValue(V bean, String value) {
        setBean(bean);
        setValue(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getValueAndSet() {
        if (StrUtil.isBlank(this.value)) {
            if (ObjUtil.isNull(bean)) {
                throw new RedisException("异常操作，value 和 bean 都为空");
            }
            String value = doGetValue(bean);
            setBeanAndValue(bean, value);
            return value;
        }
        return this.value;
    }

}
