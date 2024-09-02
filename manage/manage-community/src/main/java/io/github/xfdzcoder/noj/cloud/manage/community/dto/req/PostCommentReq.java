package io.github.xfdzcoder.noj.cloud.manage.community.dto.req;

import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class PostCommentReq implements BaseReq<PostComment> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
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


    @Override
    public Class<PostComment> getEntityClass() {
        return PostComment.class;
    }
}
