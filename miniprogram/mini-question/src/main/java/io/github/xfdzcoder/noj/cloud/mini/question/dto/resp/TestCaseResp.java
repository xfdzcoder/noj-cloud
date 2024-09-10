package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.TestCase;
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
public class TestCaseResp {

    private Long id;

    @Schema(description = "所属题目 ID")
    private Long questionInfoId;

    @Schema(description = "输入")
    private String input;

    @Schema(description = "输出")
    private String output;

    @Schema(description = "排序")
    private Integer sort;


    public static IPage<TestCaseResp> toResp(IPage<TestCase> page) {
        List<TestCaseResp> respList = BeanUtil.copyToList(page.getRecords(), TestCaseResp.class);
        IPage<TestCaseResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
