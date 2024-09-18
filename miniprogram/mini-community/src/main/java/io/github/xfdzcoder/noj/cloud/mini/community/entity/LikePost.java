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
 * 文章点赞表(LikePost)表实体类
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("like_post")
public class LikePost extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -85699204721772846L;

    /**
     * 点赞的用户 ID
     */
    @Schema(description = "点赞的用户 ID")
    @TableField("user_id")
    private Long userId;
    /**
     * 点赞的文章 ID
     */
    @Schema(description = "点赞的文章 ID")
    @TableField("post_info_id")
    private Long postInfoId;

}

