package io.github.xfdzcoder.noj.cloud.manage.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.CommunityInfo;
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

    @Schema(description = "名称")
    private String name;

    @Schema(description = "简介")
    private String description;

    @Schema(description = "关注人数")
    private Integer starCount;

    @Schema(description = "帖子数量")
    private Integer postCount;


    public static IPage<CommunityInfoResp> toResp(IPage<CommunityInfo> page) {
        List<CommunityInfoResp> respList = toResp(page.getRecords());
        IPage<CommunityInfoResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static CommunityInfoResp toResp(CommunityInfo info) {
        return BeanUtil.copyProperties(info, CommunityInfoResp.class);
    }

    public static List<CommunityInfoResp> toResp(List<CommunityInfo> infoList) {
        return BeanUtil.copyToList(infoList, CommunityInfoResp.class);
    }
}
