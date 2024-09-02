package io.github.xfdzcoder.noj.cloud.manage.user.service.impl;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.ManageUserResp;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;
import io.github.xfdzcoder.noj.cloud.manage.user.exception.ManageUserException;
import io.github.xfdzcoder.noj.cloud.manage.user.service.AuthService;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xfdzcoder
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ManageUserService manageUserService;

    @Override
    public LoginResp login(LoginReq loginReq) {
        ManageUser manageUser = manageUserService.getOne(new LambdaQueryWrapper<ManageUser>()
                .eq(ManageUser::getEmail, loginReq.getEmail()));
        if (manageUser == null) {
            throw new ManageUserException("用户不存在");
        }
        if (!manageUser.checkPassword(loginReq.getPassword())) {
            throw new ManageUserException("邮箱或密码错误");
        }

        StpUtil.login(manageUser.getId(), SaLoginConfig
                .setExtra(AuthConst.USER_ID, manageUser.getId())
        );
        return new LoginResp(StpUtil.getTokenValue(), ManageUserResp.toResp(manageUser));
    }
}
