package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Opt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.PostInfoCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.PostInfoReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.PostInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostContent;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostInfo;
import io.github.xfdzcoder.noj.cloud.mini.community.service.LikePostService;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostContentService;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostInfoService;
import jakarta.validation.constraints.NotNull;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 帖子表(PostInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
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

    @Autowired
    private LikePostService likePostService;

    @DubboReference(version = "0.0.1")
    private UserService userService;

    @GetMapping("/content/{id}")
    public Response<String> getByInfoId(@PathVariable("id") Long id) {
        return Response.ok(postContentService.getOne(new LambdaQueryWrapper<PostContent>()
                .eq(PostContent::getPostInfoId, id)).getContent());
    }

    @PostMapping("list")
    public Response<IPage<PostInfoResp>> list(@Validated(Condition.class) @RequestBody PostInfoCondition condition,
                                              @RequestHeader(AuthConst.USER_ID) Long userId) {
        Page<PostInfo> page = postInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        List<Long> postInfoIdList = page.getRecords().stream().map(PostInfo::getId).toList();
        Set<Long> lickPostIds = Opt.ofEmptyAble(postInfoIdList)
                .map(list -> likePostService.list(new LambdaQueryWrapper<LikePost>()
                                                    .eq(LikePost::getUserId, userId)
                                                    .in(LikePost::getPostInfoId, list))
                                            .stream()
                                            .map(LikePost::getPostInfoId)
                                            .collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
        List<Long> userIdList = page.getRecords().stream().map(PostInfo::getAuthor).collect(Collectors.toList());
        Map<Long, UserResp> userId2objMap = userService.listByIds(userIdList)
                                                       .stream()
                                                       .collect(Collectors.toMap(UserResp::getId, v -> v));
        return Response.ok(PostInfoResp.toResp(page, userId2objMap, lickPostIds));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody PostInfoReq req, @RequestHeader(AuthConst.USER_ID) Long userId) {
        PostInfo entity = req.toEntity();
        entity.setAuthor(userId);
        postInfoService.save(entity);
        PostContent content = new PostContent(entity.getId(), req.getContent());
        postContentService.save(content);
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

