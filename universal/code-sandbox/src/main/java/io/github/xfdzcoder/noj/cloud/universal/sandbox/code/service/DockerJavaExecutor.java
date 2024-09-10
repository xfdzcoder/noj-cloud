package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service;

import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.pojo.bo.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.pojo.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.pojo.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.utils.compiler.ExitTypeEnum;

/**
 * @author xfdzcoder
 */
public interface DockerJavaExecutor {

    ExecuteResult execute(ExecuteInfo executeInfo, TestCase testCases);

    record ExecRes(
            Object input,
            Object output,
            int time,
            int memory,
            ExitTypeEnum type
    ) {
    }
}
