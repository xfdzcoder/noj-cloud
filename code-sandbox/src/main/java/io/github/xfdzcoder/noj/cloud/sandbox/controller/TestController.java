package io.github.xfdzcoder.noj.cloud.sandbox.controller;

import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteResult;
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

    @Autowired
    private ExecuteInfoService executeInfoService;

    @Autowired
    private DockerJavaExecutor dockerJavaExecutor;

    @GetMapping("/execute")
    public ExecuteResult testExecute() {
        ExecuteInfo executeInfo = executeInfoService.getById(1825816388385075201L);
        return dockerJavaExecutor.execute(executeInfo);
    }

}
