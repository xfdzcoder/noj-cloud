package io.github.xfdzcoder.noj.cloud.mini.user.service;

import io.github.xfdzcoder.noj.cloud.mini.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.resp.LoginResp;

/**
 * @author xfdzcoder
 */
public interface AuthService {
    LoginResp login(LoginReq code);
}
