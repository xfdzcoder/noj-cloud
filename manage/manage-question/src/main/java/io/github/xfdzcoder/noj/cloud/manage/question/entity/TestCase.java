package io.github.xfdzcoder.noj.cloud.manage.question.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 测试用例表(TestCase)表实体类
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("test_case")
public class TestCase extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -41463835920842471L;

    /**
     * 所属题目 ID
     */
    @Schema(description = "所属题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;
    /**
     * 输入
     */
    @Schema(description = "输入")
    @TableField("input")
    private String input;
    /**
     * 输出
     */
    @Schema(description = "输出")
    @TableField("output")
    private String output;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField("sort")
    private Integer sort;

}

