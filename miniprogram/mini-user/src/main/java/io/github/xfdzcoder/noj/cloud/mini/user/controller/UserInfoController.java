package io.github.xfdzcoder.noj.cloud.mini.user.controller;


import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.user.dto.req.UserInfoReq;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息表(UserResp)表控制层
 *
 * @author makejava
 * @since 2024-09-03 21:53:15
 */

@Validated
@RestController
@RequestMapping("info")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private UserInfoService userInfoService;

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody UserInfoReq req) {
        userInfoService.updateById(req.toEntity());
        return Response.ok();
    }

}

