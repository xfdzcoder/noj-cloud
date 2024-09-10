package io.github.xfdzcoder.noj.cloud.mini.question.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class QuestionInfoReq implements BaseReq<QuestionInfo> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "所属题库 ID")
    private Long questionBankId;

    @Schema(description = "分组名称")
    private String groupName;

    @Schema(description = "一句话名称")
    private String title;

    @Schema(description = "题目描述")
    private String description;

    @Schema(description = "题目类型")
    private Integer questionType;

    @Schema(description = "题目标签")
    private String tags;

    @Schema(description = "难度")
    private Integer difficulty;

    @Schema(description = "通过次数")
    private Integer passCount;

    @Schema(description = "提交次数")
    private Integer submitCount;

    @Schema(description = "评论数量")
    private Integer commentCount;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "时间限制，单位毫秒")
    private Integer timeout;

    @Schema(description = "内存限制，单位 byte，仅当题目类型为编程题时有效")
    private Integer memory;


    @Override
    public Class<QuestionInfo> getEntityClass() {
        return QuestionInfo.class;
    }
}
