package io.github.xfdzcoder.noj.cloud.common.cache.operator;



import io.github.xfdzcoder.noj.cloud.common.cache.bo.StringRedisCache;

import java.util.List;

/**
 * @author Ding
 */

public interface StringRedisOperator {

    /**
     * 添加缓存
     *
     * @param stringRedisCache 需要被缓存的缓存对象
     * @param <V>        值类型
     */
    <V> void set(StringRedisCache<V> stringRedisCache);

    /**
     * 批量缓存
     *
     * @param cacheList 需要被缓存的集合
     * @param <T>       缓存类型
     * @param <V>       值类型
     */
    <T extends StringRedisCache<V>, V> void setBatch(Iterable<T> cacheList);

    /**
     * 获取原本的值
     *
     * @param stringRedisCache 缓存对象，可以只提供键，值获取出来后会填充到对象中
     * @param <V>        值类型
     * @return 返回缓存中得实际值
     */
    <V> String getString(StringRedisCache<V> stringRedisCache);

    /**
     * 获取值并将其转换为 bean
     *
     * @param stringRedisCache 缓存对象，可以只提供键，值获取出来后会填充到对象中
     * @param <V>        值类型
     * @return 返回缓存中的 bean 对象
     */
    <V> V getBean(StringRedisCache<V> stringRedisCache);

    /**
     * 批量查询
     *
     * @param cacheList 需要批量查询的键集合
     * @param <T>       缓存类型
     * @param <V>       值类型
     * @return 返回批量查询出来的值集合
     */
    <T extends StringRedisCache<V>, V> List<String> listString(Iterable<T> cacheList);

    /**
     * 批量查询并转换为 bean
     *
     * @param cacheList 需要批量查询的键集合
     * @param <T>       缓存类型
     * @param <V>       值类型
     * @return 返回批量查询出来的 bean 集合
     */
    <T extends StringRedisCache<V>, V> List<V> listBean(Iterable<T> cacheList);
}
