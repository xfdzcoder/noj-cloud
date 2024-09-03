package io.github.xfdzcoder.noj.cloud.manage.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.condition.PostInfoCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.req.PostInfoReq;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.resp.PostInfoResp;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostContent;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostInfo;
import io.github.xfdzcoder.noj.cloud.manage.community.service.PostContentService;
import io.github.xfdzcoder.noj.cloud.manage.community.service.PostInfoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子表(PostInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-02 19:46:27
 */

@Validated
@RestController
@RequestMapping("post/info")
public class PostInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private PostInfoService postInfoService;

    @Autowired
    private PostContentService postContentService;

    @GetMapping("status/{id}/{status}")
    public Response<String> disable(@PathVariable("id") Long postId, @PathVariable("status") Integer status) {
        postInfoService.update(new LambdaUpdateWrapper<PostInfo>()
                .set(PostInfo::getStatus, status)
                .eq(PostInfo::getId, postId)
        );
        return Response.ok();
    }

    @GetMapping("content/{postInfoId}")
    public Response<String> getContent(@PathVariable("postInfoId") Long id) {
        PostContent content = postContentService.getOne(new LambdaQueryWrapper<PostContent>()
                .eq(PostContent::getPostInfoId, id));
        return Response.ok(content.getContent(), "查询成功");
    }

    @PostMapping("list")
    public Response<IPage<PostInfoResp>> list(@Validated(Condition.class) @RequestBody PostInfoCondition condition) {
        Page<PostInfo> page = postInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(PostInfoResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody PostInfoReq req) {
        postInfoService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody PostInfoReq req) {
        postInfoService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        postInfoService.removeById(id);
        return Response.ok();
    }
}

