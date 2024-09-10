package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
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
public class ExecuteInfoResp {

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


    public static IPage<ExecuteInfoResp> toResp(IPage<ExecuteInfo> page) {
        List<ExecuteInfoResp> respList = BeanUtil.copyToList(page.getRecords(), ExecuteInfoResp.class);
        IPage<ExecuteInfoResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
