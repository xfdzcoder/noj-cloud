package io.github.xfdzcoder.noj.cloud.manage.community.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 社群表(CommunityInfo)表实体类
 *
 * @author makejava
 * @since 2024-09-02 10:25:44
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("community_info")
public class CommunityInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -66430254895089054L;

    /**
     * 群主的管理账号 ID
     */
    @Schema(description = "群主的管理账号 ID")
    @TableField("manage_user_id")
    private Long manageUserId;
    /**
     * 群主的C端账号 ID
     */
    @Schema(description = "群主的C端账号 ID")
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
    @TableField("star_count")
    private Integer starCount;
    /**
     * 帖子数量
     */
    @Schema(description = "帖子数量")
    @TableField("post_count")
    private Integer postCount;

}

