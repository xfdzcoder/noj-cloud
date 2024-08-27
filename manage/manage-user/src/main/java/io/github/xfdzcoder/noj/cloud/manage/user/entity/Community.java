package io.github.xfdzcoder.noj.cloud.manage.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 题圈表(Community)表实体类
 *
 * @author makejava
 * @since 2024-08-27 14:03:09
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("community")
public class Community extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -86822736031707186L;

    /**
     * 圈主的管理账号 ID
     */
    @Schema(description = "圈主的管理账号 ID")
    @TableField("manage_user_id")
    private Long manageUserId;
    /**
     * 圈主的C端账号 ID
     */
    @Schema(description = "圈主的C端账号 ID")
    @TableField("user_id")
    private Long userId;
    /**
     * 名称
     */
    @Schema(description = "名称")
    @TableField("name")
    private String name;
    /**
     * 简介
     */
    @Schema(description = "简介")
    @TableField("description")
    private String description;
    /**
     * 关注人数
     */
    @Schema(description = "关注人数")
    @TableField("start_count")
    private Integer startCount;
    /**
     * 帖子数量
     */
    @Schema(description = "帖子数量")
    @TableField("post_count")
    private Integer postCount;

}

