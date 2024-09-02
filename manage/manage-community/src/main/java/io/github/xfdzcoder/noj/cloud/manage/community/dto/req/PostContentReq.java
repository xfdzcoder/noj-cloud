package io.github.xfdzcoder.noj.cloud.manage.community.dto.req;

import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostContent;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class PostContentReq implements BaseReq<PostContent> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "帖子 ID")
    private Long postInfoId;

    @Schema(description = "内容，富文本")
    private String content;


    @Override
    public Class<PostContent> getEntityClass() {
        return PostContent.class;
    }
}
