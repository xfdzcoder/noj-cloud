package io.github.xfdzcoder.noj.cloud.manage.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionBank;
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
public class QuestionBankResp {

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


    public static IPage<QuestionBankResp> toResp(IPage<QuestionBank> page) {
        List<QuestionBankResp> respList = BeanUtil.copyToList(page.getRecords(), QuestionBankResp.class);
        IPage<QuestionBankResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static List<QuestionBankResp> toResp(List<QuestionBank> list) {
        return BeanUtil.copyToList(list, QuestionBankResp.class);
    }
}
