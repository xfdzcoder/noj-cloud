package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.Answer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResp {

    private Long id;

    @Schema(description = "所属题目 ID")
    private Long questionInfoId;

    @Schema(description = "编号，具体是什么根据题目类型决定。例如：0在选择题中表示 A。在填空题中表示第一个空")
    private Integer optionIdentifier;

    @Schema(description = "答案内容")
    private String content;

    @Schema(description = "是否是正确答案")
    private Boolean correct;

    @Schema(description = "排序")
    private Integer sort;


    public static IPage<AnswerResp> toResp(IPage<Answer> page) {
        List<AnswerResp> respList = BeanUtil.copyToList(page.getRecords(), AnswerResp.class);
        IPage<AnswerResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
