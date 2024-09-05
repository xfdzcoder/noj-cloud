package io.github.xfdzcoder.noj.cloud.mini.user.controller;

import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.mini.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xfdzcoder
 */

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("login")
    public Response<LoginResp> login(@RequestParam("code") String code) {
        return Response.ok(authService.login(code));
    }

}
