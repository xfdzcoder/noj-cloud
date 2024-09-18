package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;
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
public class LikePostResp {

    private Long id;

    @Schema(description = "点赞的用户 ID")
    private Long userId;

    @Schema(description = "点赞的文章 ID")
    private Long postInfoId;


    public static IPage<LikePostResp> toResp(IPage<LikePost> page) {
        List<LikePostResp> respList = BeanUtil.copyToList(page.getRecords(), LikePostResp.class);
        IPage<LikePostResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
