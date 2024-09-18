package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.LikeCommentCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.LikeCommentReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.LikeCommentResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikeComment;
import io.github.xfdzcoder.noj.cloud.mini.community.service.LikeCommentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论点赞表(LikeComment)表控制层
 *
 * @author makejava
 * @since 2024-09-18 18:43:51
 */

@Validated
@RestController
@RequestMapping("like/comment")
public class LikeCommentController {
    /**
     * 服务对象
     */
    @Autowired
    private LikeCommentService likeCommentService;

    @GetMapping("{postInfoId}")
    public Response<List<Long>> getCommentIdByPostInfoId(@RequestHeader(AuthConst.USER_ID) Long userId,
                                                         @PathVariable("postInfoId") Long postInfoId) {
        return Response.ok(likeCommentService.list(new LambdaQueryWrapper<LikeComment>()
                .eq(LikeComment::getUserId, userId)
                .eq(LikeComment::getPostInfoId, postInfoId))
                .stream().map(LikeComment::getCommentId)
                .toList());
    }

    @PostMapping("list")
    public Response<IPage<LikeCommentResp>> list(@Validated(Condition.class) @RequestBody LikeCommentCondition condition,
                                                 @RequestHeader(AuthConst.USER_ID) Long userId) {
        Page<LikeComment> page = likeCommentService.page(condition.getPage(), condition.getLambdaQueryWrapper()
                .eq(LikeComment::getUserId, userId));
        return Response.ok(LikeCommentResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody LikeCommentReq req,
                                 @RequestHeader(AuthConst.USER_ID) Long userId) {
        LikeComment entity = req.toEntity();
        entity.setUserId(userId);
        likeCommentService.save(entity);
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody LikeCommentReq req) {
        likeCommentService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        likeCommentService.removeById(id);
        return Response.ok();
    }
}

