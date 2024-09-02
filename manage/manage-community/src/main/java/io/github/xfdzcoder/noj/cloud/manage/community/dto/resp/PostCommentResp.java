package io.github.xfdzcoder.noj.cloud.manage.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
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
public class PostCommentResp {

    private Long id;

    @Schema(description = "帖子信息 ID")
    private Long postInfoId;

    @Schema(description = "父评论 ID")
    private Long parentId;

    @Schema(description = "评论者")
    private Long author;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "点赞量")
    private Integer goodCount;

    @Schema(description = "回复量")
    private Integer commentCount;


    public static IPage<PostCommentResp> toResp(IPage<PostComment> page) {
        List<PostCommentResp> respList = BeanUtil.copyToList(page.getRecords(), PostCommentResp.class);
        IPage<PostCommentResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
