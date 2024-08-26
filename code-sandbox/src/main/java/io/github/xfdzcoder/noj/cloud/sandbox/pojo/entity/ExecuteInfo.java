package io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 执行信息表(ExecuteInfo)表实体类
 *
 * @author makejava
 * @since 2024-08-19 12:20:06
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("execute_info")
public class ExecuteInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -34710369613004044L;

    /**
     * 对应题目 ID
     */
    @Schema(description = "对应题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;


    /**
     * 使用的测试用例 ID
     */
    @Schema(description = "使用的测试用例 ID")
    @TableField("test_case_id")
    private Long testCaseId;


    /**
     * 代码文本
     */
    @Schema(description = "代码文本")
    @TableField("code_text")
    private String codeText;


    /**
     * 代码文件大小，单位字节
     */
    @Schema(description = "代码文件大小，单位字节")
    @TableField("size")
    private Integer size;


    /**
     * 编程语言类型
     */
    @Schema(description = "编程语言类型")
    @TableField("language_type")
    // TODO 2024/8/25 12:43 on dev-xfdzcoder: 待实现：多语言支持
    private String languageType;


    /**
     * 运行类型，ACM 模式 或 核心方法模式
     */
    @Schema(description = "运行类型，0: ACM 模式 或 1: 核心方法模式")
    @TableField("run_type")
    private Integer runType;


    /**
     * 时间限制，单位毫秒
     */
    @Schema(description = "时间限制，单位毫秒")
    @TableField("timeout")
    private Integer timeout;


    /**
     * 内存限制，单位 Byte
     */
    @Schema(description = "内存限制，单位 Byte")
    @TableField("memory")
    private Integer memory;


}

