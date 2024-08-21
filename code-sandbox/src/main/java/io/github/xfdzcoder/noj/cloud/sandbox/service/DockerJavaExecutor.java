package io.github.xfdzcoder.noj.cloud.sandbox.service;

import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteResult;
import io.github.xfdzcoder.noj.framework.sandbox.java.ExitTypeEnum;

/**
 * @author xfdzcoder
 */
public interface DockerJavaExecutor {

    ExecuteResult execute(ExecuteInfo executeInfo);

    record ExecRes(
            Object input,
            Object output,
            int time,
            int memory,
            ExitTypeEnum type
    ) {
    }
}
