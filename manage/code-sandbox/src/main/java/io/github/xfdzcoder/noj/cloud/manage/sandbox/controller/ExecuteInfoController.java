package io.github.xfdzcoder.noj.cloud.manage.sandbox.controller;


import io.github.xfdzcoder.noj.cloud.manage.sandbox.service.ExecuteInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 执行信息表(ExecuteInfo)表控制层
 *
 * @author makejava
 * @since 2024-08-19 12:20:06
 */
@RestController
@RequestMapping("executeInfo")
public class ExecuteInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ExecuteInfoService executeInfoService;


}

