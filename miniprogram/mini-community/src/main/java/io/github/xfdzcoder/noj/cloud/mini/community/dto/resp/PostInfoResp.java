package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto.UserResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoResp {

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

    @Schema(description = "作者头像")
    private String avatar;

    @Schema(description = "作者昵称")
    private String authorName;


    public static IPage<PostInfoResp> toResp(IPage<PostInfo> page, Map<Long, UserResp> userId2objMap) {
        List<PostInfoResp> respList = page.getRecords().stream()
                                      .map(info -> {
                                          PostInfoResp resp = BeanUtil.copyProperties(info, PostInfoResp.class);
                                          UserResp userResp = userId2objMap.get(resp.getAuthor());
                                          resp.setAvatar(userResp.getAvatar());
                                          resp.setAuthorName(userResp.getNickname());
                                          return resp;
                                      }).toList();
        IPage<PostInfoResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
