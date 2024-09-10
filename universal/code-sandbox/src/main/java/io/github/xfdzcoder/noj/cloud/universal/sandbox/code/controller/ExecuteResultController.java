package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.controller;


import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.ExecuteResultService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运行结果表(ExecuteResult)表控制层
 *
 * @author makejava
 * @since 2024-08-19 12:20:06
 */
@RestController
@RequestMapping("executeResult")
public class ExecuteResultController {
    /**
     * 服务对象
     */
    @Resource
    private ExecuteResultService executeResultService;


}

