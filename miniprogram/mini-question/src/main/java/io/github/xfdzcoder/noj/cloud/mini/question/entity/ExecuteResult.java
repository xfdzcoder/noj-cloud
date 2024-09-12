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
 * 运行结果表(ExecuteResp)表实体类
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("execute_result")
public class ExecuteResult extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -55204706498822727L;

    /**
     * 用户 ID
     */
    @Schema(description = "用户 ID")
    @TableField("user_id")
    private Long userId;

    /**
     * 对应题目 ID
     */
    @Schema(description = "对应题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;

    /**
     * 执行信息 ID
     */
    @Schema(description = "执行信息 ID")
    @TableField("execute_info_id")
    private Long executeInfoId;
    /**
     * 是否执行成功
     */
    @Schema(description = "是否执行成功")
    @TableField("succeed")
    private Boolean succeed;
    /**
     * 平均耗时，单位毫秒
     */
    @Schema(description = "平均耗时，单位毫秒")
    @TableField("avg_time")
    private Integer avgTime;
    /**
     * 平均使用内存，单位 MB
     */
    @Schema(description = "平均使用内存，单位 MB")
    @TableField("avg_memory")
    private Integer avgMemory;
    /**
     * 通过测试用例数量
     */
    @Schema(description = "通过测试用例数量")
    @TableField("passed_case_count")
    private Integer passedCaseCount;
    /**
     * 测试用例总数
     */
    @Schema(description = "测试用例总数")
    @TableField("total_case_count")
    private Integer totalCaseCount;
    /**
     * 输入，仅在错误时有值
     */
    @Schema(description = "输入，仅在错误时有值")
    @TableField("input")
    private Object input;
    /**
     * 输出，仅在错误时有值
     */
    @Schema(description = "输出，仅在错误时有值")
    @TableField("output")
    private Object output;
    /**
     * 期望输出，仅在错误时有值
     */
    @Schema(description = "期望输出，仅在错误时有值")
    @TableField("except_output")
    private Object exceptOutput;
    /**
     * 异常输出，仅在错误时有值
     */
    @Schema(description = "异常输出，仅在错误时有值")
    @TableField("throwable_output")
    private String throwableOutput;
    /**
     * 退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；
     */
    @Schema(description = "退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；")
    @TableField("exit_type")
    private Integer exitType;

}

