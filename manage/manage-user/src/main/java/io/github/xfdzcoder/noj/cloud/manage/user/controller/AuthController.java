package io.github.xfdzcoder.noj.cloud.manage.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.manage.user.exception.ManageUserException;
import io.github.xfdzcoder.noj.cloud.manage.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xfdzcoder
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Response<LoginResp> login(@RequestBody LoginReq loginReq) {
        if (loginReq.getCode() == null || !loginReq.getCode()) {
            throw new ManageUserException("请先进行人机验证");
        }
        return Response.ok(authService.login(loginReq));
    }

    @GetMapping("/logout")
    public Response<String> logout() {
        // TODO 2024/9/2 18:35 on dev-xfdzcoder: 删除用户缓存
        StpUtil.logout();
        return Response.ok();
    }

}
