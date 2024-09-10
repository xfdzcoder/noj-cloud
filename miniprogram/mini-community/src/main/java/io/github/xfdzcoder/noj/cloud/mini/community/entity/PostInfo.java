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
 * 帖子表(PostInfo)表实体类
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("post_info")
public class PostInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 823307741197977362L;

    /**
     * 作者
     */
    @Schema(description = "作者")
    @TableField("author")
    private Long author;
    /**
     * 所属社群
     */
    @Schema(description = "所属社群")
    @TableField("community_info_id")
    private Long communityInfoId;
    /**
     * 标题
     */
    @Schema(description = "标题")
    @TableField("title")
    private String title;
    /**
     * 摘要
     */
    @Schema(description = "摘要")
    @TableField("summary")
    private String summary;
    /**
     * 标签，多个使用英文逗号分隔
     */
    @Schema(description = "标签，多个使用英文逗号分隔")
    @TableField("tags")
    private String tags;
    /**
     * 类型，0为正常帖子，1为错题反馈，2为新题建议
     */
    @Schema(description = "类型，0为正常帖子，1为错题反馈，2为新题建议")
    @TableField("type")
    private Integer type;
    /**
     * 点赞量
     */
    @Schema(description = "点赞量")
    @TableField("good_count")
    private Integer goodCount;
    /**
     * 评论量
     */
    @Schema(description = "评论量")
    @TableField("comment_count")
    private Integer commentCount;
    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    @TableField("topped")
    private Boolean topped;
    /**
     * 状态，0为草稿，1为已发布，2为已封禁
     */
    @Schema(description = "状态，0为草稿，1为已发布，2为已封禁")
    @TableField("status")
    private Integer status;

}

