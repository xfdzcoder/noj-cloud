package io.github.xfdzcoder.noj.cloud.mini.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.file.config.MinioUtil;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.UserInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.AuthService;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public LoginResp login(LoginReq req) {
        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getEmail, req.getEmail())
                .eq(UserInfo::getPassword, req.getPassword()));
        if (ObjUtil.isNull(userInfo)) {
            return null;
        }

        String url = minioUtil.getPresignedObjectUrl(userInfo.getAvatar(), 180, TimeUnit.DAYS);
        userInfo.setAvatar(url);

        StpUtil.login(userInfo.getId());
        String token = StpUtil.getTokenValue();

        return new LoginResp(UserInfoResp.toResp(userInfo), token);
    }
}
