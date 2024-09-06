package io.github.xfdzcoder.noj.cloud.common.cache.bo;

import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * redis 缓存类的顶级接口
 *
 * @author Ding
 */

public interface StringRedisCache<V> {

    /**
     * @return 此缓存的 Key
     */
    String getCacheKey();

    /**
     * @return 此缓存的值
     */
    String getValueAndSet();

    /**
     * 获取 bean 并且 存储 value 和 bean
     *
     * @return 返回缓存值对应的 bean
     */
    V getBeanAndSet();

    /**
     * 根据指定的 value 获取 bean 对象
     *
     * @param value 缓存的值，不为 null 或 空
     * @return 返回转换后的 bean 对象
     */
    V doGetBean(@NonNull String value);

    /**
     * 根据指定的 bean 获取 value 对象
     *
     * @param bean 缓存的 bean，不为 null
     * @return 返回转换后的 string
     */
    String doGetValue(@NonNull V bean);


    /**
     * @return 缓存时间
     */
    Long getTimeout();

    /**
     * @return 缓存时间单位
     */
    TimeUnit getTimeUnit();

    void setValue(String value);

    void setBean(V bean);

}
