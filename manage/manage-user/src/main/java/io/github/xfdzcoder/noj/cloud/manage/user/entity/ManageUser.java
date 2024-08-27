package io.github.xfdzcoder.noj.cloud.manage.user.entity;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员用户表(ManageUser)表实体类
 *
 * @author makejava
 * @since 2024-08-27 11:50:00
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("manage_user")
public class ManageUser extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -90899093202352244L;

    /**
     * 该管理员在C端的ID
     */
    @Schema(description = "该管理员在C端的ID")
    @TableField("user_id")
    private Long userId;
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    @TableField("nickname")
    private String nickname;
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @TableField("email")
    private String email;
    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField("password")
    private String password;

    public String hashpw(String password) {
        return BCrypt.hashpw(password);
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}

