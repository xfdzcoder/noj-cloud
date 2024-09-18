package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.LikePostCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.LikePostReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.LikePostResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;
import io.github.xfdzcoder.noj.cloud.mini.community.service.LikePostService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文章点赞表(LikePost)表控制层
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */

@Validated
@RestController
@RequestMapping("like/post")
public class LikePostController {
    /**
     * 服务对象
     */
    @Autowired
    private LikePostService likePostService;

    @PostMapping("list")
    public Response<IPage<LikePostResp>> list(@Validated(Condition.class) @RequestBody LikePostCondition condition) {
        Page<LikePost> page = likePostService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(LikePostResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody LikePostReq req) {
        likePostService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody LikePostReq req) {
        likePostService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        likePostService.removeById(id);
        return Response.ok();
    }
}

