package io.github.xfdzcoder.noj.cloud.manage.question.dto.req;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.TestCase;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
/**
 * @author xfdzcoder
 */

@Data
public class TestCaseReq implements BaseReq<TestCase> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "所属题目 ID")
    @NotNull(groups = Save.class, message = "题目信息不能为空")
    private Long questionInfoId;

    @Schema(description = "输入")
    private String input;

    @Schema(description = "输出")
    private String output;

    @Schema(description = "排序")
    private Integer sort;


    @Override
    public Class<TestCase> getEntityClass() {
        return TestCase.class;
    }
}
