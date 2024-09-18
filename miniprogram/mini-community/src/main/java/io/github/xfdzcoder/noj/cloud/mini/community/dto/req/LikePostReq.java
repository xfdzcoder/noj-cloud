package io.github.xfdzcoder.noj.cloud.mini.community.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class LikePostReq implements BaseReq<LikePost> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "点赞的用户 ID")
    private Long userId;

    @Schema(description = "点赞的文章 ID")
    private Long postInfoId;


    @Override
    public Class<LikePost> getEntityClass() {
        return LikePost.class;
    }
}
