package io.github.xfdzcoder.noj.cloud.mini.question.service;

import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.CodeExecuteReq;

/**
 * @author xfdzcoder
 */
public interface CodeExecuteService {
    String execute(Long userId, CodeExecuteReq req, long bodyLength);
}
