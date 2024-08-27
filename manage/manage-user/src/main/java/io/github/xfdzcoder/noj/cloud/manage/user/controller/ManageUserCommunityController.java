package io.github.xfdzcoder.noj.cloud.manage.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.web.web.Response;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.condition.ManageUserCommunityCondition;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUserCommunity;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员管理的题圈表(ManageUserCommunity)表控制层
 *
 * @author makejava
 * @since 2024-08-27 11:50:01
 */
@RestController
@RequestMapping("manageUserCommunity")
public class ManageUserCommunityController {
    /**
     * 服务对象
     */
    @Autowired
    private ManageUserCommunityService manageUserCommunityService;

    @PostMapping("list")
    public Response<Page<ManageUserCommunity>> list(ManageUserCommunityCondition condition) {
        Page<ManageUserCommunity> page = manageUserCommunityService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(page);
    }

    @PostMapping
    public Response<String> save(@RequestBody ManageUserCommunity manageUserCommunity) {
        manageUserCommunityService.save(manageUserCommunity);
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@RequestBody ManageUserCommunity manageUserCommunity) {
        manageUserCommunityService.updateById(manageUserCommunity);
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") Long id) {
        manageUserCommunityService.removeById(id);
        return Response.ok();
    }
}

