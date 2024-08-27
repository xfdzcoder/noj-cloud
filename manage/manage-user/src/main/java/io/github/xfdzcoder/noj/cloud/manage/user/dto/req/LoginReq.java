package io.github.xfdzcoder.noj.cloud.manage.user.dto.req;

import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class LoginReq {

    private String email;

    private String password;

    private Boolean code;

}
