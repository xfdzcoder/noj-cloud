package io.github.xfdzcoder.noj.cloud.manage.user.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class ManageUserResp {

    private Long id;

    @Schema(description = "该管理员在C端的ID")
    private Long userId;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "邮箱")
    private String email;

    public static ManageUserResp toResp(ManageUser manageUser) {
        return BeanUtil.copyProperties(manageUser, ManageUserResp.class);
    }
}
