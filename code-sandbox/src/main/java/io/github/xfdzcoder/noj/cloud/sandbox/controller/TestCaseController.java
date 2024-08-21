package io.github.xfdzcoder.noj.cloud.sandbox.controller;


import io.github.xfdzcoder.noj.cloud.sandbox.service.TestCaseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例表(TestCase)表控制层
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */
@RestController
@RequestMapping("testCase")
public class TestCaseController {
    /**
     * 服务对象
     */
    @Resource
    private TestCaseService testCaseService;


}

