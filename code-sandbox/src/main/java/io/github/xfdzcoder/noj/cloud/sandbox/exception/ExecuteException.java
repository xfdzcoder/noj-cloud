package io.github.xfdzcoder.noj.cloud.sandbox.exception;

import io.github.xfdzcoder.noj.cloud.sandbox.service.DockerJavaExecutor;
import lombok.Getter;

/**
 * @author: xfdzcoder
 */

@Getter
public class ExecuteException extends RuntimeException {

    private DockerJavaExecutor.ExecRes execRes;

    public ExecuteException() {
    }

    public ExecuteException(Throwable cause) {
        super(cause);
    }

    public ExecuteException(String message) {
        super(message);
    }

    public ExecuteException(DockerJavaExecutor.ExecRes execRes) {
        this.execRes = execRes;
    }
}
