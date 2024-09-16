package io.github.xfdzcoder.noj.cloud.universal.copilot.api;

import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeReq;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeResp;

import java.util.concurrent.CompletableFuture;

/**
 * @author xfdzcoder
 */
public interface SparkService {

    String ask(String question);

    CompletableFuture<CodeOptimizeResp> codeOptimize(CodeOptimizeReq req);
}
