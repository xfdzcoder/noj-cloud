package io.github.xfdzcoder.noj.cloud.mini.common.cache.redis.consts;

/**
 * @author xfdzcoder
 */
public interface RedisKeyConst {

    String BASE = "mini:";

    /**
     * BASE + register: + {@code UserInfo#id}
     */
    String REGISTER = BASE + "register:{}";

}
