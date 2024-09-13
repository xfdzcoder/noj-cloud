package io.github.xfdzcoder.noj.cloud.mini.question.service;

import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.CodeExecuteReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteInfoResp;

/**
 * @author xfdzcoder
 */
public interface CodeExecuteService {
    ExecuteInfoResp execute(Long userId, CodeExecuteReq req, long bodyLength);
}
