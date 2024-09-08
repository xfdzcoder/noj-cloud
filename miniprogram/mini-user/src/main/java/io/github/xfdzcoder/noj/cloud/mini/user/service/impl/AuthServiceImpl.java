package io.github.xfdzcoder.noj.cloud.mini.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.github.xfdzcoder.noj.cloud.mini.user.config.WeChatApiProperties;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.UserInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.WeChatApiLoginResp;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.AuthService;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author xfdzcoder
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private RestClient restClient;

    @Autowired
    private WeChatApiProperties weChatApiProperties;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @PostConstruct
    public void init() {
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        restClient = RestClient.builder()
                               .baseUrl(weChatApiProperties.getCode2session())
                               .messageConverters(httpMessageConverters -> {
                                   httpMessageConverters.add(mappingJackson2HttpMessageConverter);
                               })
                               .requestInterceptor(new ClientHttpRequestInterceptor() {
                                   @Override
                                   public @NonNull ClientHttpResponse intercept(@NonNull HttpRequest request, @NonNull byte[] body, @NonNull ClientHttpRequestExecution execution) throws IOException {
                                       log.info("""
                                                       请求拦截器：
                                                       method: {}
                                                       uri: {}
                                                       query: {}
                                                       headers: {}""",
                                               request.getMethod(),
                                               request.getURI().getPath(),
                                               request.getURI().getQuery(),
                                               JSONUtil.toJsonPrettyStr(request.getHeaders())
                                       );
                                       return execution.execute(request, body);
                                   }
                               })
                               .build();
    }

    @Override
    public LoginResp login(LoginReq req) {
        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getEmail, req.getEmail())
                .eq(UserInfo::getPassword, req.getPassword()));
        if (ObjUtil.isNull(userInfo)) {
            return null;
        }
        StpUtil.login(userInfo.getId());
        String token = StpUtil.getTokenValue();

        return new LoginResp(UserInfoResp.toResp(userInfo), token);
    }

    /*@Override
    public LoginResp login(String code) {
        WeChatApiLoginResp loginResp = restClient.get()
                                                 .uri((builder) -> builder
                                                         .queryParam("js_code", code)
                                                         .queryParam("appid", weChatApiProperties.getAppid())
                                                         .queryParam("secret", weChatApiProperties.getAppSecret())
                                                         .queryParam("grant_type", "authorization_code").build())
                                                 .accept(MediaType.APPLICATION_JSON)
                                                 .acceptCharset(StandardCharsets.UTF_8)
                                                 .retrieve()
                                                 .body(WeChatApiLoginResp.class);

        if (ObjUtil.isNull(loginResp) || ObjUtil.isNotNull(loginResp.getErrcode())) {
            log.error("微信登录接口请求失败，\n接收到的code：{}\n错误信息如下：\n{}", code, JSONUtil.toJsonPrettyStr(loginResp));
            throw new RuntimeException("登录失败，服务器异常");
        }

        String unionid = loginResp.getUnionid();
        String openid = loginResp.getOpenid();

        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getOpenid, openid)
                .eq(UserInfo::getUnionid, unionid)
        );

        UserInfoResp resp;
        if (ObjUtil.isNull(userInfo)) {
            userInfo = new UserInfo();
            userInfo.setOpenid(loginResp.getOpenid());
            userInfo.setUnionid(loginResp.getUnionid());
            userInfo.setId(IdWorker.getId(userInfo));

            userInfoService.save(userInfo);
            resp = UserInfoResp.toResp(userInfo);
        } else {
            resp = UserInfoResp.toResp(userInfo);
            resp.setOpenid(openid);
            resp.setUnionid(unionid);
        }

        StpUtil.login(resp.getId());
        String token = StpUtil.getTokenValue();

        return new LoginResp(resp, token);
    }*/
}
