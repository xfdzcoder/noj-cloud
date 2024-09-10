package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service;

import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteResp;

import java.util.concurrent.CompletableFuture;

/**
 * @author xfdzcoder
 */
public interface CodeExecutor {

    CompletableFuture<ExecuteResp> executeAsync(ExecuteReq executeReq);

    ExecuteResp executeSync(ExecuteReq executeReq);

}
