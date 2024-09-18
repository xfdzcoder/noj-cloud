package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.PostContentCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.PostContentReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.PostContentResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostContent;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostContentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子内容表(PostContent)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
 */

@Validated
@RestController
@RequestMapping("post/content")
public class PostContentController {
    /**
     * 服务对象
     */
    @Autowired
    private PostContentService postContentService;

    @PostMapping("list")
    public Response<IPage<PostContentResp>> list(@Validated(Condition.class) @RequestBody PostContentCondition condition) {
        Page<PostContent> page = postContentService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(PostContentResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody PostContentReq req) {
        postContentService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody PostContentReq req) {
        postContentService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        postContentService.removeById(id);
        return Response.ok();
    }
}

