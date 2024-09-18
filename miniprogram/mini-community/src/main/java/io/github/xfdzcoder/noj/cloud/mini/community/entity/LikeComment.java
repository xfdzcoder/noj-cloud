package io.github.xfdzcoder.noj.cloud.mini.community.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 评论点赞表(LikeComment)表实体类
 *
 * @author makejava
 * @since 2024-09-18 18:43:51
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("like_comment")
public class LikeComment extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 354683845396477645L;

    /**
     * 点赞的用户 ID
     */
    @Schema(description = "点赞的用户 ID")
    @TableField("user_id")
    private Long userId;
    /**
     * 被点赞的评论 ID
     */
    @Schema(description = "被点赞的评论 ID")
    @TableField("comment_id")
    private Long commentId;
    /**
     * 被点赞的评论的文章 ID
     */
    @Schema(description = "被点赞的评论的文章 ID")
    @TableField("post_info_id")
    private Long postInfoId;

}

