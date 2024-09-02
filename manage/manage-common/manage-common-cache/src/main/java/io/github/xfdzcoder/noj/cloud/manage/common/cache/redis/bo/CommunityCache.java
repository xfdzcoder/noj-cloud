package io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.bo;

import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.consts.RedisKeyConst;
import lombok.Data;

/**
 * @author xfdzcoder
 */
public class CommunityCache extends AbstractStringRedisCache<CommunityCache.CommunityBo> {

    public CommunityCache(Long userId) {
        super(String.valueOf(userId));
    }

    public CommunityCache(Long userId, CommunityBo bean) {
        super(String.valueOf(userId), bean);
    }

    @Override
    public String getKeyPattern() {
        return RedisKeyConst.CURRENT_COMMUNITY;
    }

    @Override
    public CommunityBo doGetBean(String value) {
        return JSONUtil.toBean(value, CommunityBo.class);
    }

    @Override
    public String doGetValue(CommunityBo bean) {
        return JSONUtil.toJsonStr(bean);
    }

    @Data
    public static class CommunityBo {

        private Long id;

        /**
         * 群主的C端账号 ID
         */
        private Long userId;

        /**
         * 名称
         */
        private String name;

    }

}
