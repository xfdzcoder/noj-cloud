package io.github.xfdzcoder.noj.cloud.mini.question.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
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

    @Schema(description = "题圈 ID")
    private Long communityId;

    @Schema(description = "唯一编号")
    private String identifier;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "题目数量")
    private Integer questionCount;

    @Schema(description = "好评数量")
    private Integer goodCount;

    @Schema(description = "评论数量")
    private Integer commentCount;

    @Schema(description = "学习过人数")
    private Integer studyCount;


    @Override
    public Class<QuestionBank> getEntityClass() {
        return QuestionBank.class;
    }
}
