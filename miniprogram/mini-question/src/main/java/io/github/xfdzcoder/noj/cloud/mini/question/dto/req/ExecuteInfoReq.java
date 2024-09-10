package io.github.xfdzcoder.noj.cloud.mini.question.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class ExecuteInfoReq implements BaseReq<ExecuteInfo> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "对应题目 ID")
    private Long questionInfoId;

    @Schema(description = "使用的测试用例 ID")
    private Long testCaseId;

    @Schema(description = "代码文本")
    private String codeText;

    @Schema(description = "代码文件大小，单位字节")
    private Long size;

    @Schema(description = "编程语言类型")
    private String languageType;

    @Schema(description = "运行类型，0:ACM 模式 或 1:核心方法模式")
    private Integer runType;

    @Schema(description = "时间限制，单位毫秒")
    private Integer timeout;

    @Schema(description = "内存限制，单位 KB")
    private Integer memory;


    @Override
    public Class<ExecuteInfo> getEntityClass() {
        return ExecuteInfo.class;
    }
}
