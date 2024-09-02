package io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.consts;



/**
 * 存放 Redis 缓存 Key 的模板字符串
 *
 * @author Ding
 */

public interface RedisKeyConst {

    String BASE = "manage:";

    /**
     * current-community:{@code ManageUser#id}
     */
    String CURRENT_COMMUNITY = BASE + "current-community:{}";
}
