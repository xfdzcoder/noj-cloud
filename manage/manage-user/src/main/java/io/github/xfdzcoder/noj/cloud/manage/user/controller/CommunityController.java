package io.github.xfdzcoder.noj.cloud.manage.user.controller;


import io.github.xfdzcoder.noj.cloud.manage.user.service.CommunityService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.condition.CommunityCondition;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 题圈表(Community)表控制层
 *
 * @author makejava
 * @since 2024-08-27 14:03:09
 */
@RestController
@RequestMapping("community")
public class CommunityController {
    /**
     * 服务对象
     */
    @Autowired
    private CommunityService communityService;

    @PostMapping("list")
    public Response<Page<Community>> list(CommunityCondition condition) {
        Page<Community> page = communityService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(page);
    }

    @PostMapping
    public Response<String> save(@RequestBody Community community) {
        communityService.save(community);
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@RequestBody Community community) {
        communityService.updateById(community);
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") Long id) {
        communityService.removeById(id);
        return Response.ok();
    }
}

