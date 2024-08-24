package io.github.xfdzcoder.noj.cloud.aiadapter.controller;

import io.github.xfdzcoder.noj.cloud.common.web.Response;
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
        return Response.ok("ai-adapter stated", "");
    }

}
