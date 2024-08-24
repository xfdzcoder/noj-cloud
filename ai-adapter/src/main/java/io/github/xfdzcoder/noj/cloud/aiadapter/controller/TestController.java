package io.github.xfdzcoder.noj.cloud.aiadapter.controller;

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
    public String test() {
        return "ai-adapter stated";
    }

}
