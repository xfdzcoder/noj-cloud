package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service;

import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExitTypeEnum;

import java.util.List;

/**
 * @author xfdzcoder
 */
public interface DockerJavaExecutor {

    ExecuteResp execute(ExecuteReq executeReq, List<TestCase> testCases);

    record ExecRes(
            Object input,
            Object output,
            int time,
            int memory,
            ExitTypeEnum type
    ) {
    }
}
