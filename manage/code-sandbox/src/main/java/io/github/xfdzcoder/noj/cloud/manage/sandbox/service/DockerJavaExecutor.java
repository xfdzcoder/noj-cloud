package io.github.xfdzcoder.noj.cloud.manage.sandbox.service;

import io.github.xfdzcoder.noj.cloud.manage.sandbox.pojo.bo.TestCase;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.pojo.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.pojo.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.utils.compiler.ExitTypeEnum;

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
