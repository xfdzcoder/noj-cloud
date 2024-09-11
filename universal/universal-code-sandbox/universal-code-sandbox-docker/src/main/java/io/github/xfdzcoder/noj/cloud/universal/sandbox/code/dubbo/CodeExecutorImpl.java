package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.dubbo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.CodeExecutor;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.DockerJavaExecutor;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.TestCaseService;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xfdzcoder
 */

@DubboService(version = "0.0.1", timeout = 20000)
public class CodeExecutorImpl implements CodeExecutor {

    @Autowired
    private DockerJavaExecutor dockerJavaExecutor;

    @Autowired
    private TestCaseService testCaseService;

    @Override
    public CompletableFuture<ExecuteResp> executeAsync(final ExecuteReq executeReq) {
        return CompletableFuture.supplyAsync(() -> executeSync(executeReq));
    }

    @Override
    public ExecuteResp executeSync(final ExecuteReq executeReq) {
        List<TestCase> caseList = testCaseService.list(new LambdaQueryWrapper<TestCase>()
                .eq(TestCase::getQuestionInfoId, executeReq.getQuestionInfoId()));

        return dockerJavaExecutor.execute(executeReq, caseList);
    }
}
