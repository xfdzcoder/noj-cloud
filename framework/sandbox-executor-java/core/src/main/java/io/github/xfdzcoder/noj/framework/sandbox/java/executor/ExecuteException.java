package io.github.xfdzcoder.noj.framework.sandbox.java.executor;

import io.github.xfdzcoder.noj.framework.sandbox.java.Result;

/**
 * @author: xfdzcoder
 */
public class ExecuteException extends RuntimeException {

    private Result<Object, Object> result;


    public ExecuteException() {
    }

    public ExecuteException(Throwable cause) {
        super(cause);
    }

    public ExecuteException(String message) {
        super(message);
    }

    public <I, O> ExecuteException(Result<I, O> result) {
        this.result = (Result<Object, Object>) result;
    }

    public Result<Object, Object> getResult() {
        return result;
    }
}
