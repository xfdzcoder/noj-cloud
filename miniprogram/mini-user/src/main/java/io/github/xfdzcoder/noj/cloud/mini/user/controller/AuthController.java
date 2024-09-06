package io.github.xfdzcoder.noj.cloud.mini.user.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.github.xfdzcoder.noj.cloud.common.cache.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.cache.redis.bo.RegisterCache;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.req.RegisterReq;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.UserInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.AuthService;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xfdzcoder
 */

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("login")
    public Response<LoginResp> login(@RequestParam("code") String code) {
        return Response.ok(authService.login(code));
    }

    @GetMapping("captcha")
    public Response<String> captcha(@RequestParam("email") String email,
                                    @RequestHeader(AuthConst.USER_ID) Long userId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderMail);
        message.setTo(email);
        message.setSubject("NOJ 注册 验证码");
        String captcha = String.valueOf(RandomUtil.randomInt(100000, 1000000));
        redisOperator.opsStr().set(new RegisterCache(userId, captcha));
        log.info("获取验证码成功，验证码为：{}", captcha);
        message.setText(StrFormatter.format("您好，欢迎注册您 NOJ，您的验证码是 {}，验证码五分钟内有效。若您未进行此操作，可忽略本邮件。", captcha));
        message.setSentDate(DateUtil.date().toJdkDate());
        javaMailSender.send(message);
        return Response.ok(captcha);
    }

    @PostMapping("register")
    public Response<UserInfoResp> register(@RequestBody RegisterReq req, @RequestHeader(AuthConst.USER_ID) Long userId) {
        RegisterCache.RegisterBo registerBo = redisOperator.opsStr().getBean(new RegisterCache(userId));
        if (! StrUtil.equals(registerBo.getCaptcha(), req.getCaptcha())) {
            return Response.fail("验证码错误");
        }
        UserInfo entity = req.toEntity();
        entity.setId(userId);
        userInfoService.updateById(entity);
        return Response.ok(UserInfoResp.toResp(userInfoService.getById(userId)));
    }
}
