package io.github.xfdzcoder.noj.cloud.mini.user.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class UserInfoReq implements BaseReq<UserInfo> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "微信小程序的 openid")
    private String openid;

    @Schema(description = "微信开放平台的 unionid")
    private String unionid;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "密码，绑定邮箱后可以通过邮箱+密码登录")
    private String password;

    @Schema(description = "社群信息 ID，可以绑定多个，用英文逗号分隔")
    private String communityInfoIds;


    @Override
    public Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }
}
