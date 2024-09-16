package io.github.xfdzcoder.noj.cloud.universal.copilot.api;

import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeReq;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeResp;

/**
 * @author xfdzcoder
 */
public interface SparkService {

    String ask(String question);

    CodeOptimizeResp codeOptimize(CodeOptimizeReq req);
}
