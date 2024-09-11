package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 运行结果表(ExecuteResp)表实体类
 *
 * @author makejava
 * @since 2024-08-19 12:20:06
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 580770968040769734L;

    /**
     * 执行信息 ID
     */
    @Schema(description = "执行信息 ID")
    private Long executeInfoId;


    /**
     * 是否执行成功
     */
    @Schema(description = "是否执行成功")
    private Boolean succeed;


    /**
     * 平均耗时，单位毫秒
     */
    @Schema(description = "平均耗时，单位毫秒")
    private Integer avgTime;


    /**
     * 平均使用内存，单位 KB
     */
    @Schema(description = "平均使用内存，单位 KB")
    private Integer avgMemory;


    /**
     * 通过测试用例数量
     */
    @Schema(description = "通过测试用例数量")
    private Integer passedCaseCount;


    /**
     * 测试用例总数
     */
    @Schema(description = "测试用例总数")
    private Integer totalCaseCount;


    /**
     * 输入，仅在错误时有值
     */
    @Schema(description = "输入，仅在错误时有值")
    private Object input;


    /**
     * 输出，仅在错误时有值
     */
    @Schema(description = "输出，仅在错误时有值")
    private Object output;


    /**
     * 期望输出，仅在错误时有值
     */
    @Schema(description = "期望输出，仅在错误时有值")
    private Object exceptOutput;


    /**
     * 异常输出，仅在错误时有值
     */
    @Schema(description = "异常输出，仅在错误时有值")
    private String throwableOutput;


    /**
     * 退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；
     */
    @Schema(description = "退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；")
    private ExitTypeEnum exitType;

}

