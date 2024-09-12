package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.controller;


import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.TestCaseService;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestCaseService testCaseService;

    @GetMapping
    public Response<String> test() {
        return Response.ok("sandbox started", "");
    }

    @GetMapping("driver")
    public Response<String> testDriver() {
        List<TestCase> caseList = testCaseService.list();
        log.info(JSONUtil.toJsonPrettyStr(caseList));
        return Response.ok();
    }

}
