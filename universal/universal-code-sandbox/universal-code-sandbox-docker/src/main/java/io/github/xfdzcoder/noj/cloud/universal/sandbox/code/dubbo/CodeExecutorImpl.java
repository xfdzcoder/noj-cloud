package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.dubbo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrFormatter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.CodeExecutor;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.DockerJavaExecutor;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.TestCaseService;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExitTypeEnum;
import jakarta.annotation.PostConstruct;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */

@DubboService(version = "0.0.1", timeout = 20000)
public class CodeExecutorImpl implements CodeExecutor {

    @Autowired
    private DockerJavaExecutor dockerJavaExecutor;

    @Autowired
    private TestCaseService testCaseService;

    private ThreadPoolExecutor executor;

    @PostConstruct
    public void init() {
        executor = new ThreadPoolExecutor(
                8,
                16,
                30,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                new DubboServiceThreadFactory("CodeExecuteImpl"),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    @Override
    public CompletableFuture<ExecuteResp> executeAsync(final ExecuteReq executeReq) {
        return CompletableFuture.supplyAsync(() -> executeSync(executeReq), executor);
    }

    @Override
    public ExecuteResp executeSync(final ExecuteReq executeReq) {
        List<TestCase> caseList = testCaseService.list(new LambdaQueryWrapper<TestCase>()
                .eq(TestCase::getQuestionInfoId, executeReq.getQuestionInfoId()));

        if (CollUtil.isEmpty(caseList)) {
            ExecuteResp resp = new ExecuteResp();
            resp.setExitType(ExitTypeEnum.SYSTEM_ERROR);
            resp.setThrowableOutput(StrFormatter.format("ID为 {} 的题目的可用测试用例为空", executeReq.getQuestionInfoId()));
            return resp;
        }

        return dockerJavaExecutor.execute(executeReq, caseList);
    }


}

/*
import io.netty.util.concurrent.DefaultThreadFactory;
import jakarta.annotation.PostConstruct;


    private ThreadPoolExecutor executor;


 */