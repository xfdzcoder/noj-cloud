package io.github.xfdzcoder.noj.cloud.manage.gateway.auth.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Collections;

/**
 * @author xfdzcoder
 */

@Slf4j
@Configuration
public class SaTokenConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthProperties authProperties;

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    @Primary
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 指定 [拦截路由]
                .setIncludeList(Collections.singletonList("/**"))
                // 指定 [放行路由]
                .setExcludeList(Collections.emptyList())
                // 指定 [认证前置操作]
//                .setBeforeAuth()
                // 指定 [认证函数]: 每次请求执行
                .setAuth(ignore -> {
                    SaRouter.match("/**")
                            .notMatch(SaHttpMethod.OPTIONS)
//                            .notMatch("/api/*/user/auth/login")
//                            .notMatch("/api/*/user/auth/register")
                            .notMatch(authProperties.getExcludePaths())
                            .check(StpUtil::checkLogin);
                })
                // 指定 [异常处理函数]：每次 [认证函数] 发生异常时执行此函数
                .setError(e -> {
                    Response<String> res = Response.fail(null, "认证失败，请重新登录");
                    try {
                        log.error("认证失败，异常信息：\n{}", ExceptionUtil.stacktraceToString(e));
                        return objectMapper.writeValueAsString(res);
                    } catch (JsonProcessingException ex) {
                        JSON json = JSONUtil.parse(res);
                        json.putByPath("code", res.getCode().getCode());
                        log.error("认证失败返回信息序列化错误，序列化对象：\n{}\n序列化异常消息：\n{}",
                                json,
                                ExceptionUtil.stacktraceToString(ex)
                        );
                        return json.toString();
                    }
                })
                ;
    }

}
