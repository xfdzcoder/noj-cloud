package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.UserService;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto.UserResp;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.PostCommentCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.PostCommentReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.PostCommentResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostCommentService;
import jakarta.validation.constraints.NotNull;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 帖子评论(PostComment)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:03:36
 */

@Validated
@RestController
@RequestMapping("post/comment")
public class PostCommentController {
    /**
     * 服务对象
     */
    @Autowired
    private PostCommentService postCommentService;

    @DubboReference(version = "0.0.1")
    private UserService userService;

    @PostMapping("list")
    public Response<IPage<PostCommentResp>> list(@Validated(Condition.class) @RequestBody PostCommentCondition condition) {
        Page<PostComment> page = postCommentService.page(condition.getPage(), condition.getLambdaQueryWrapper());

        List<Long> totalUserIdList = new LinkedList<>();
        List<Long> parentIdList = page.getRecords().stream()
                                      .filter(comment -> ObjUtil.isNotNull(comment.getCommentCount()) && comment.getCommentCount() > 0)
                                      .map(PostComment::getId)
                                      .toList();
        Map<Long, List<PostComment>> childMap = MapUtil.empty();
        if (CollUtil.isNotEmpty(parentIdList)) {
            List<PostComment> childList = postCommentService.page(Page.of(1, 10), new LambdaQueryWrapper<PostComment>()
                                                                    .eq(PostComment::getPostInfoId, condition.getPostInfoId())
                                                                    .in(PostComment::getParentId, parentIdList))
                                                            .getRecords();
            childMap = childList
                    .stream()
                    .collect(Collectors.groupingBy(PostComment::getParentId));
            totalUserIdList.addAll(childList.stream().map(PostComment::getAuthor).toList());
        }

        totalUserIdList.addAll(page.getRecords().stream().map(PostComment::getAuthor).toList());
        Map<Long, UserResp> userId2objMap = userService.listByIds(totalUserIdList)
                                                       .stream()
                                                       .collect(Collectors.toMap(UserResp::getId, v -> v));
        List<PostCommentResp> respList = new LinkedList<>();
        for (PostComment comment : page.getRecords()) {
            PostCommentResp resp = PostCommentResp.toResp(comment);
            resp.setUser(new PostCommentResp.User(userId2objMap.get(comment.getAuthor())));
            resp.setUid(comment.getAuthor());
            resp.setCreateTime(comment.getCreateDateTime());
            if (ObjUtil.isNotNull(resp.getCommentCount()) && resp.getCommentCount() > 0 && childMap.containsKey(resp.getId())) {
                PostCommentResp.Reply reply = new PostCommentResp.Reply();
                reply.setTotal(comment.getCommentCount());
                List<PostComment> childList = childMap.get(resp.getId());
                List<PostCommentResp> childRespList = childList.stream()
                                                               .map(child -> {
                                                                   PostCommentResp childResp = PostCommentResp.toResp(child);
                                                                   childResp.setUser(new PostCommentResp.User(userId2objMap.get(child.getAuthor())));
                                                                   childResp.setUid(child.getAuthor());
                                                                   childResp.setCreateTime(child.getCreateDateTime());
                                                                   return childResp;
                                                               }).toList();
                reply.setList(childRespList);
                resp.setReply(reply);
            }
            respList.add(resp);
        }
        Page<PostCommentResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return Response.ok(respPage);
    }

    @PostMapping
    public Response<PostCommentResp> save(@Validated(Save.class) @RequestBody PostCommentReq req,
                                          @RequestHeader(AuthConst.USER_ID) Long userId) {

        PostComment entity = req.toEntity();
        entity.setAuthor(userId);
        postCommentService.save(entity);
        postCommentService.update(new LambdaUpdateWrapper<PostComment>()
                .setSql("comment_count = comment_count + 1")
                .eq(PostComment::getParentId, req.getParentId()));
        return Response.ok(PostCommentResp.toResp(entity));
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody PostCommentReq req) {
        postCommentService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        postCommentService.removeById(id);
        return Response.ok();
    }
}

