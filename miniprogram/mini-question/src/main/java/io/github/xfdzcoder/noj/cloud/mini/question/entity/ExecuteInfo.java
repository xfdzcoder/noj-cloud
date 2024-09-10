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
 * 执行信息表(ExecuteReq)表实体类
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("execute_info")
public class ExecuteInfo extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 461403912888408008L;

    /**
     * 对应题目 ID
     */
    @Schema(description = "对应题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;

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
    private Long size;
    /**
     * 编程语言类型
     */
    @Schema(description = "编程语言类型")
    @TableField("language_type")
    private String languageType;
    /**
     * 运行类型，0:ACM 模式 或 1:核心方法模式
     */
    @Schema(description = "运行类型，0:ACM 模式 或 1:核心方法模式")
    @TableField("run_type")
    private Integer runType;
    /**
     * 时间限制，单位毫秒
     */
    @Schema(description = "时间限制，单位毫秒")
    @TableField("timeout")
    private Integer timeout;
    /**
     * 内存限制，单位 KB
     */
    @Schema(description = "内存限制，单位 KB")
    @TableField("memory")
    private Integer memory;

}

