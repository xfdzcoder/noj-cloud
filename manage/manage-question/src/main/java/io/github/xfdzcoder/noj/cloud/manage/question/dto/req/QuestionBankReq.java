package io.github.xfdzcoder.noj.cloud.manage.question.dto.req;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionBank;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class QuestionBankReq implements BaseReq<QuestionBank> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "社群 ID")
    @NotNull(groups = Save.class, message = "社群ID不能为空")
    @Null(groups = Update.class, message = "不允许修改社群")
    private Long communityId;

    @Schema(description = "名称")
    @NotNull(groups = Save.class, message = "名称不能为空")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Override
    public Class<QuestionBank> getEntityClass() {
        return QuestionBank.class;
    }
}
