package io.github.xfdzcoder.noj.cloud.manage.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员管理的题圈表(ManageUserCommunity)表实体类
 *
 * @author makejava
 * @since 2024-08-27 11:50:01
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("manage_user_community")
public class ManageUserCommunity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 335287249323334381L;

    /**
     * 题圈 ID
     */
    @Schema(description = "题圈 ID")
    @TableField("community_id")
    private Long communityId;
    /**
     * 管理员 ID
     */
    @Schema(description = "管理员 ID")
    @TableField("manage_user_id")
    private Long manageUserId;

}

