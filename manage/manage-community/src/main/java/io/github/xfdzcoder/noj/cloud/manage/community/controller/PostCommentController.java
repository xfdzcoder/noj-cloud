package io.github.xfdzcoder.noj.cloud.manage.community.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.condition.PostCommentCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.req.PostCommentReq;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.resp.PostCommentResp;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.manage.community.service.PostCommentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子评论(PostComment)表控制层
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
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

    @PostMapping("list")
    public Response<IPage<PostCommentResp>> list(@Validated(Condition.class) @RequestBody PostCommentCondition condition) {
        Page<PostComment> page = postCommentService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(PostCommentResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody PostCommentReq req) {
        postCommentService.save(req.toEntity());
        return Response.ok();
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

