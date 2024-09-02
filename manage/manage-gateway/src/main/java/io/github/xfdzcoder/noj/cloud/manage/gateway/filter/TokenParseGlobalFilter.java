package io.github.xfdzcoder.noj.cloud.manage.gateway.filter;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.gateway.auth.config.AuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TokenParseGlobalFilter implements GlobalFilter {

    @Autowired
    private AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        SaRequest request = SaHolder.getRequest();
        log.info("==== {} {}", request.getMethod(), request.getRequestPath());

        if (SaRouter.isMatch(authProperties.getExcludePaths(), SaHolder.getRequest().getRequestPath())
                || HttpMethod.OPTIONS == exchange.getRequest().getMethod()) {
            return chain.filter(exchange);
        }

        long userId = Long.parseLong(StpUtil.getExtra(AuthConst.USER_ID).toString());

        log.info("token 解析成功。当前请求的 \nuserId: {}\n", userId);

        return chain.filter(
                exchange.mutate().request(
                        requestBuilder ->
                                requestBuilder.headers(httpHeaders -> {
                                    httpHeaders.add(AuthConst.USER_ID, String.valueOf(userId));
                                })
                ).build()
        );
    }

}
