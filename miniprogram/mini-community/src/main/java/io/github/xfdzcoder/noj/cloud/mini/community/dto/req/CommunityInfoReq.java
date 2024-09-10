package io.github.xfdzcoder.noj.cloud.mini.community.dto.req;

import io.github.xfdzcoder.noj.cloud.mini.community.entity.CommunityInfo;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class CommunityInfoReq implements BaseReq<CommunityInfo> {

    @Null(groups = Save.class, message = "ID必须为空")
    @NotNull(groups = Update.class, message = "ID 不能为空")
    private Long id;

    @Schema(description = "群主的管理账号 ID")
    private Long manageUserId;

    @Schema(description = "群主的C端账号 ID")
    private Long userId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "简介")
    private String description;

    @Schema(description = "关注人数")
    private Integer starCount;

    @Schema(description = "帖子数量")
    private Integer postCount;


    @Override
    public Class<CommunityInfo> getEntityClass() {
        return CommunityInfo.class;
    }
}
