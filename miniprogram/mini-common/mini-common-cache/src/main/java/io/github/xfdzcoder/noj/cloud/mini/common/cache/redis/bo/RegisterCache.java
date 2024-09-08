package io.github.xfdzcoder.noj.cloud.mini.common.cache.redis.bo;

import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.common.cache.bo.AbstractStringRedisCache;
import io.github.xfdzcoder.noj.cloud.mini.common.cache.redis.consts.RedisKeyConst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */
public class RegisterCache extends AbstractStringRedisCache<RegisterCache.RegisterBo> {

    public RegisterCache(String email, String captcha) {
        super(email, new RegisterBo(captcha));
    }

    public RegisterCache(String email) {
        super(email);
    }

    @Override
    public String getKeyPattern() {
        return RedisKeyConst.REGISTER;
    }

    @Override
    public RegisterBo doGetBean(@NonNull String value) {
        return JSONUtil.toBean(value, RegisterBo.class);
    }

    @Override
    public String doGetValue(@NonNull RegisterBo bean) {
        return JSONUtil.toJsonStr(bean);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterBo {

        private String captcha;

    }

    @Override
    public Long getTimeout() {
        return 5L;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.MINUTES;
    }
}
