package io.github.xfdzcoder.noj.cloud.sandbox.controller;

import io.github.xfdzcoder.noj.cloud.common.web.Response;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.sandbox.service.DockerJavaExecutor;
import io.github.xfdzcoder.noj.cloud.sandbox.service.ExecuteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xfdzcoder
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Response<String> test() {
        return Response.ok("sandbox started", "");
    }

}
