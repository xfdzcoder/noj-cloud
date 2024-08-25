package io.github.xfdzcoder.noj.cloud.question.controller;


import io.github.xfdzcoder.noj.cloud.question.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例表(TestCase)表控制层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@RestController
@RequestMapping("testCase")
public class TestCaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TestCaseService testCaseService;


}

