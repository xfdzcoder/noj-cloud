package io.github.xfdzcoder.noj.cloud.manage.question.dto.req;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.Answer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class AnswerReq implements BaseReq<Answer> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "所属题目 ID")
    @NotNull(groups = Save.class, message = "题目 ID 不能为空")
    private Long questionInfoId;

    @Schema(description = "编号，具体是什么根据题目类型决定。例如：0在选择题中表示 A。在填空题中表示第一个空")
    @NotNull(groups = Save.class, message = "题目编号不能为空")
    private Integer optionIdentifier;

    @Schema(description = "答案内容")
    @NotBlank(groups = Save.class, message = "答案不能为空")
    private String content;

    @Schema(description = "是否是正确答案")
    @NotNull(groups = Save.class, message = "是否是正确答案不能为空")
    private Boolean correct;

    @Schema(description = "排序")
    private Integer sort;

    @Override
    public Class<Answer> getEntityClass() {
        return Answer.class;
    }
}
