package io.github.xfdzcoder.noj.cloud.question.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * 题库表(QuestionBank)表实体类
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("question_bank")
public class QuestionBank extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 632533623214714071L;

    /**
     * 题圈 ID
     */
    @Schema(description = "题圈 ID")
    @TableField("community_id")
    private Long communityId;
    /**
     * 唯一编号
     */
    @Schema(description = "唯一编号")
    @TableField("identifier")
    private String identifier;
    /**
     * 名称
     */
    @Schema(description = "名称")
    @TableField("name")
    private String name;
    /**
     * 描述
     */
    @Schema(description = "描述")
    @TableField("description")
    private String description;
    /**
     * 题目数量
     */
    @Schema(description = "题目数量")
    @TableField("question_count")
    private Integer questionCount;
    /**
     * 好评数量
     */
    @Schema(description = "好评数量")
    @TableField("good_count")
    private Integer goodCount;
    /**
     * 评论数量
     */
    @Schema(description = "评论数量")
    @TableField("comment_count")
    private Integer commentCount;
    /**
     * 学习过人数
     */
    @Schema(description = "学习过人数")
    @TableField("study_count")
    private Integer studyCount;

}

