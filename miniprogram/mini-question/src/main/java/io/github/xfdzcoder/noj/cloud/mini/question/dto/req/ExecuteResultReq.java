package io.github.xfdzcoder.noj.cloud.mini.question.dto.req;

import com.baomidou.mybatisplus.annotation.TableField;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class ExecuteResultReq implements BaseReq<ExecuteResult> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "用户 ID")
    private Long userId;

    @Schema(description = "对应题目 ID")
    private Long questionInfoId;

    @Schema(description = "执行信息 ID")
    private Long executeInfoId;

    @Schema(description = "是否执行成功")
    private Boolean succeed;

    @Schema(description = "平均耗时，单位毫秒")
    private Integer avgTime;

    @Schema(description = "平均使用内存，单位 MB")
    private Integer avgMemory;

    @Schema(description = "通过测试用例数量")
    private Integer passedCaseCount;

    @Schema(description = "测试用例总数")
    private Integer totalCaseCount;

    @Schema(description = "输入，仅在错误时有值")
    private Object input;

    @Schema(description = "输出，仅在错误时有值")
    private Object output;

    @Schema(description = "期望输出，仅在错误时有值")
    private Object exceptOutput;

    @Schema(description = "异常输出，仅在错误时有值")
    private String throwableOutput;

    @Schema(description = "退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；")
    private Integer exitType;


    @Override
    public Class<ExecuteResult> getEntityClass() {
        return ExecuteResult.class;
    }
}
