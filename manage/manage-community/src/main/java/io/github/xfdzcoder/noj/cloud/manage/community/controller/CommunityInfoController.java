package io.github.xfdzcoder.noj.cloud.manage.community.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.bo.CommunityCache;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.condition.CommunityInfoCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.req.CommunityInfoReq;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.resp.CommunityInfoResp;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.CommunityInfo;
import io.github.xfdzcoder.noj.cloud.manage.community.service.CommunityInfoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 社群表(CommunityInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-02 10:25:44
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

    @Autowired
    private RedisOperator redisOperator;

    @GetMapping("change/{communityId}")
    public Response<CommunityInfoResp> change(@RequestHeader(AuthConst.USER_ID) Long userId,
                                              @PathVariable("communityId") Long communityId) {
        boolean exists = communityInfoService.exists(new LambdaQueryWrapper<CommunityInfo>()
                .eq(CommunityInfo::getManageUserId, userId)
                .eq(CommunityInfo::getId, communityId)
        );
        if (!exists) {
            return Response.fail("不存在的社群，请刷新后重试");
        }

        CommunityInfo info = communityInfoService.getById(communityId);
        CommunityCache cache = new CommunityCache(userId, BeanUtil.copyProperties(info, CommunityCache.CommunityBo.class));
        redisOperator.opsStr().set(cache);
        return Response.ok(CommunityInfoResp.toResp(info), "切换成功");
    }

    @PostMapping("list")
    public Response<IPage<CommunityInfoResp>> list(@Validated(Condition.class) @RequestBody CommunityInfoCondition condition,
                                                   @RequestHeader(AuthConst.USER_ID) Long userId) {
        Page<CommunityInfo> page = communityInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper()
                                                                                           .eq(CommunityInfo::getManageUserId, userId));
        return Response.ok(CommunityInfoResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody CommunityInfoReq req,
                                 @RequestHeader(AuthConst.USER_ID) Long userId) {
        req.setManageUserId(userId);
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
        return Response.fail("不允许删除");
    }
}

