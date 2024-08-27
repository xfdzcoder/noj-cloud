package io.github.xfdzcoder.noj.cloud.manage.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.web.web.Response;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.condition.ManageUserCondition;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员用户表(ManageUser)表控制层
 *
 * @author makejava
 * @since 2024-08-27 11:50:00
 */
@RestController
@RequestMapping("manageUser")
public class ManageUserController {
    /**
     * 服务对象
     */
    @Autowired
    private ManageUserService manageUserService;

    @PostMapping("list")
    public Response<Page<ManageUser>> list(ManageUserCondition condition) {
        Page<ManageUser> page = manageUserService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(page);
    }

    @PostMapping
    public Response<String> save(@RequestBody ManageUser manageUser) {
        manageUserService.save(manageUser);
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@RequestBody ManageUser manageUser) {
        manageUserService.updateById(manageUser);
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") Long id) {
        manageUserService.removeById(id);
        return Response.ok();
    }
}

