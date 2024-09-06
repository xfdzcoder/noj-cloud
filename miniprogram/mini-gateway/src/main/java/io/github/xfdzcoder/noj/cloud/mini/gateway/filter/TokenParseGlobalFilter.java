package io.github.xfdzcoder.noj.cloud.mini.gateway.filter;

import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.gateway.config.AuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xfdzcoder
 */

@Slf4j
@Component
public class TokenParseGlobalFilter implements GlobalFilter {

    @Autowired
    private AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        RequestPath path = request.getPath();
        HttpMethod method = request.getMethod();
        log.info("接收到请求：\nMethod: {}\nUri: {}", method.name(), path.value());

        if (SaRouter.isMatch(authProperties.getExcludePaths(), path.value())
                || HttpMethod.OPTIONS.equals(method)) {
            return chain.filter(exchange);
        }

        // TODO 2024/9/6 8:39 on dev-xfdzcoder: 处理未登录时的异常
        long userId = StpUtil.getLoginIdAsLong();
        log.info("用户 ID: {} 已登录，即将放行", userId);
        ServerWebExchange newExchange = exchange.mutate()
                                                .request(req ->
                                                        req.headers(headers ->
                                                                headers.add(AuthConst.USER_ID, String.valueOf(userId))
                                                        ))
                                                .build();
        return chain.filter(newExchange);
    }
}
