package io.github.xfdzcoder.noj.cloud.mini.question.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 题目表(QuestionInfo)表实体类
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("question_info")
public class QuestionInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -97146931746006635L;

    /**
     * 所属题库 ID
     */
    @Schema(description = "所属题库 ID")
    @TableField("question_bank_id")
    private Long questionBankId;
    /**
     * 分组名称
     */
    @Schema(description = "分组名称")
    @TableField("group_name")
    private String groupName;
    /**
     * 一句话名称
     */
    @Schema(description = "一句话名称")
    @TableField("title")
    private String title;
    /**
     * 题目描述
     */
    @Schema(description = "题目描述")
    @TableField("description")
    private String description;
    /**
     * 题目类型
     */
    @Schema(description = "题目类型")
    @TableField("question_type")
    private Integer questionType;
    /**
     * 题目标签
     */
    @Schema(description = "题目标签")
    @TableField("tags")
    private String tags;
    /**
     * 难度
     */
    @Schema(description = "难度")
    @TableField("difficulty")
    private Integer difficulty;
    /**
     * 通过次数
     */
    @Schema(description = "通过次数")
    @TableField("pass_count")
    private Integer passCount;
    /**
     * 提交次数
     */
    @Schema(description = "提交次数")
    @TableField("submit_count")
    private Integer submitCount;
    /**
     * 评论数量
     */
    @Schema(description = "评论数量")
    @TableField("comment_count")
    private Integer commentCount;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField("sort")
    private Integer sort;
    /**
     * 时间限制，单位毫秒
     */
    @Schema(description = "时间限制，单位毫秒")
    @TableField("timeout")
    private Integer timeout;
    /**
     * 内存限制，单位 byte，仅当题目类型为编程题时有效
     */
    @Schema(description = "内存限制，单位 byte，仅当题目类型为编程题时有效")
    @TableField("memory")
    private Integer memory;

}
