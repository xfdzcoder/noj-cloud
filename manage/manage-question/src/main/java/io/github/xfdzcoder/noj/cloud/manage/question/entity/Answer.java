package io.github.xfdzcoder.noj.cloud.manage.question.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 答案表(Answer)表实体类
 *
 * @author makejava
 * @since 2024-08-27 21:56:32
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("answer")
public class Answer extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 351067864718432990L;

    /**
     * 所属题目 ID
     */
    @Schema(description = "所属题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;
    /**
     * 编号，具体是什么根据题目类型决定。例如：0在选择题中表示 A。在填空题中表示第一个空
     */
    @Schema(description = "编号，具体是什么根据题目类型决定。例如：0在选择题中表示 A。在填空题中表示第一个空")
    @TableField("option_identifier")
    private Integer optionIdentifier;
    /**
     * 答案内容
     */
    @Schema(description = "答案内容")
    @TableField("content")
    private String content;
    /**
     * 是否是正确答案
     */
    @Schema(description = "是否是正确答案")
    @TableField("correct")
    private Boolean correct;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField("order")
    private Integer order;

}

