package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -34710369613004044L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private Long id;

    /**
     * 题目信息 ID
     */
    @Schema(description = "题目信息 ID")
    private Long questionInfoId;

    /**
     * 代码文本
     */
    @Schema(description = "代码文本")
    private String codeText;

    /**
     * 代码文件大小，单位字节
     */
    @Schema(description = "代码文件大小，单位字节")
    private Integer size;

    /**
     * 编程语言类型
     */
    @Schema(description = "编程语言类型")
    // TODO 2024/8/25 12:43 on dev-xfdzcoder: 待实现：多语言支持
    private String languageType;

    /**
     * 运行类型，ACM 模式 或 核心方法模式
     */
    @Schema(description = "运行类型，0: ACM 模式 或 1: 核心方法模式")
    private Integer runType;

    /**
     * 时间限制，单位毫秒
     */
    @Schema(description = "时间限制，单位毫秒")
    private Integer timeout;

    /**
     * 内存限制，单位 Byte
     */
    @Schema(description = "内存限制，单位 Byte")
    private Integer memory;

}

