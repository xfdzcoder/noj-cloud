package io.github.xfdzcoder.noj.cloud.manage.community.dto.req;

import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostInfo;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class PostInfoReq implements BaseReq<PostInfo> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "作者")
    private Long author;

    @Schema(description = "所属社群")
    private Long communityInfoId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "摘要")
    private String summary;

    @Schema(description = "标签，多个使用英文逗号分隔")
    private String tags;

    @Schema(description = "类型，0为正常帖子，1为错题反馈，2为新题建议")
    private Integer type;

    @Schema(description = "点赞量")
    private Integer goodCount;

    @Schema(description = "评论量")
    private Integer commentCount;

    @Schema(description = "是否置顶")
    private Boolean topped;

    @Schema(description = "状态，0为草稿，1为已发布，2为已封禁")
    private Integer status;


    @Override
    public Class<PostInfo> getEntityClass() {
        return PostInfo.class;
    }
}
