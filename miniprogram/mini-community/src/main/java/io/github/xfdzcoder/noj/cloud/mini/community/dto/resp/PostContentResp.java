package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostContent;
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
public class PostContentResp {

    private Long id;

    @Schema(description = "帖子 ID")
    private Long postInfoId;

    @Schema(description = "内容，富文本")
    private String content;


    public static IPage<PostContentResp> toResp(IPage<PostContent> page) {
        List<PostContentResp> respList = BeanUtil.copyToList(page.getRecords(), PostContentResp.class);
        IPage<PostContentResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
