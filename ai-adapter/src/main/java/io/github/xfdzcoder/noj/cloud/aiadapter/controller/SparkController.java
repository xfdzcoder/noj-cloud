package io.github.xfdzcoder.noj.cloud.aiadapter.controller;

import io.github.xfdzcoder.noj.cloud.aiadapter.dto.req.SparkReq;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.service.SparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xfdzcoder
 */

@RequestMapping("/spark")
@RestController
public class SparkController {

    @Autowired
    private SparkService sparkService;

    @PostMapping("/ask")
    public String ask(@RequestBody SparkReq sparkReq) {
        return sparkService.ask(sparkReq.getQuestion());
    }

}
