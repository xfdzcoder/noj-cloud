package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikeComment;
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
public class LikeCommentResp {

    private Long id;

    @Schema(description = "点赞的用户 ID")
    private Long userId;

    @Schema(description = "被点赞的评论 ID")
    private Long commentId;

    @Schema(description = "被点赞的评论的文章 ID")
    private Long postInfoId;


    public static IPage<LikeCommentResp> toResp(IPage<LikeComment> page) {
        List<LikeCommentResp> respList = BeanUtil.copyToList(page.getRecords(), LikeCommentResp.class);
        IPage<LikeCommentResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
