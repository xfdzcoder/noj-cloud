package io.github.xfdzcoder.noj.cloud.mini.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户信息表(UserResp)表实体类
 *
 * @author makejava
 * @since 2024-09-03 21:53:15
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("user_info")
public class UserInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 983594976120959629L;

    /**
     * 微信小程序的 openid
     */
    @Schema(description = "微信小程序的 openid")
    @TableField("openid")
    private String openid;
    /**
     * 微信开放平台的 unionid
     */
    @Schema(description = "微信开放平台的 unionid")
    @TableField("unionid")
    private String unionid;
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    @TableField("nickname")
    private String nickname;
    /**
     * 头像
     */
    @Schema(description = "头像")
    @TableField("avatar")
    private String avatar;
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @TableField("email")
    private String email;
    /**
     * 密码，绑定邮箱后可以通过邮箱+密码登录
     */
    @Schema(description = "密码，绑定邮箱后可以通过邮箱+密码登录")
    @TableField("password")
    private String password;
    /**
     * 社群信息 ID，可以绑定多个，用英文逗号分隔
     */
    @Schema(description = "社群信息 ID，可以绑定多个，用英文逗号分隔")
    @TableField("community_info_ids")
    private String communityInfoIds;

}

