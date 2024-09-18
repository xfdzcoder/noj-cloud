package io.github.xfdzcoder.noj.cloud.mini.community.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto.UserResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostComment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @Schema(description = "根评论 ID")
    private Long rootId;

    @Schema(description = "评论者")
    private User user;

    @Schema(description = "回复者 ID")
    private Long uid;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "点赞量")
    private Integer goodCount;

    @Schema(description = "回复量")
    private Integer commentCount;

    private LocalDateTime createTime;

    @Schema(description = "回复")
    private Reply reply;

    public static PostCommentResp toResp(PostComment comment) {
        return BeanUtil.copyProperties(comment, PostCommentResp.class);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {

        private Long id;

        private String nickname;

        private String avatar;

        public User(UserResp userResp) {
            this.id = userResp.getId();
            this.nickname = userResp.getNickname();
            this.avatar = userResp.getAvatar();
        }

//        private String homeLink;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Reply {

        private Integer total;

        private List<PostCommentResp> list;

    }

    public static IPage<PostCommentResp> toResp(IPage<PostComment> page) {
        List<PostCommentResp> respList = BeanUtil.copyToList(page.getRecords(), PostCommentResp.class);
        IPage<PostCommentResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }
}
