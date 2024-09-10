package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.CommunityInfo;
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
public class CommunityInfoResp {

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


    public static IPage<CommunityInfoResp> toResp(IPage<CommunityInfo> page) {
        List<CommunityInfoResp> respList = BeanUtil.copyToList(page.getRecords(), CommunityInfoResp.class);
        IPage<CommunityInfoResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static List<CommunityInfoResp> toResp(List<CommunityInfo> records) {
        return BeanUtil.copyToList(records, CommunityInfoResp.class);
    }
}
