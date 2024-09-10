package io.github.xfdzcoder.noj.cloud.mini.community.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.condition.CommunityInfoCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.req.CommunityInfoReq;
import io.github.xfdzcoder.noj.cloud.mini.community.dto.resp.CommunityInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.CommunityInfo;
import io.github.xfdzcoder.noj.cloud.mini.community.service.CommunityInfoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 社群表(CommunityInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:03:35
 */

@Validated
@RestController
@RequestMapping("info")
public class CommunityInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private CommunityInfoService communityInfoService;

    @GetMapping("hot")
    public Response<List<CommunityInfoResp>> hotList() {
        Page<CommunityInfo> page = communityInfoService.page(Page.of(1, 10), new LambdaQueryWrapper<CommunityInfo>()
                .orderByDesc(CommunityInfo::getPostCount)
                .orderByDesc(CommunityInfo::getStarCount)
        );
        if (CollUtil.isEmpty(page.getRecords())) {
            return Response.ok(ListUtil.empty());
        }
        return Response.ok(CommunityInfoResp.toResp(page.getRecords()));
    }

    @PostMapping("list")
    public Response<IPage<CommunityInfoResp>> list(@Validated(Condition.class) @RequestBody CommunityInfoCondition condition) {
        Page<CommunityInfo> page = communityInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(CommunityInfoResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody CommunityInfoReq req) {
        communityInfoService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody CommunityInfoReq req) {
        communityInfoService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        communityInfoService.removeById(id);
        return Response.ok();
    }
}

