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
 * 帖子评论(PostComment)表实体类
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("post_comment")
public class PostComment extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -29846028354535032L;

    /**
     * 帖子信息 ID
     */
    @Schema(description = "帖子信息 ID")
    @TableField("post_info_id")
    private Long postInfoId;
    /**
     * 父评论 ID
     */
    @Schema(description = "父评论 ID")
    @TableField("parent_id")
    private Long parentId;

    /**
     * 根评论 ID
     */
    @Schema(description = "根评论 ID")
    @TableField("root_id")
    private Long rootId;

    /**
     * 评论者
     */
    @Schema(description = "评论者")
    @TableField("author")
    private Long author;
    /**
     * 内容
     */
    @Schema(description = "内容")
    @TableField("content")
    private String content;
    /**
     * 点赞量
     */
    @Schema(description = "点赞量")
    @TableField("good_count")
    private Integer goodCount;
    /**
     * 回复量
     */
    @Schema(description = "回复量")
    @TableField("comment_count")
    private Integer commentCount;

}

