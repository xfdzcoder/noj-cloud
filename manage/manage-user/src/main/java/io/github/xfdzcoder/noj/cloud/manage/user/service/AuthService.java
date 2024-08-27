package io.github.xfdzcoder.noj.cloud.manage.user.service;

import io.github.xfdzcoder.noj.cloud.manage.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.LoginResp;

/**
 * @author xfdzcoder
 */
public interface AuthService {

    LoginResp login(LoginReq loginReq);

}
