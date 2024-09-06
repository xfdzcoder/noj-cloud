package io.github.xfdzcoder.noj.cloud.mini.user.dto.req;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class RegisterReq implements BaseReq<UserInfo> {

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "发送到邮箱的验证码")
    private String captcha;

    @Schema(description = "密码，绑定邮箱后可以通过邮箱+密码登录")
    private String password;

    @Schema(description = "确认密码，需要校验两个密码是否一致")
    private String confirmPassword;

    @Override
    public Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }
}
