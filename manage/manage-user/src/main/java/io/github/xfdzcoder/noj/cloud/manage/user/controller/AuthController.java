package io.github.xfdzcoder.noj.cloud.manage.user.controller;

import io.github.xfdzcoder.noj.cloud.common.web.web.Response;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.manage.user.exception.ManageUserException;
import io.github.xfdzcoder.noj.cloud.manage.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
