package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.exception;

/**
 * @author xfdzcoder
 */
public class CodeSandboxException extends RuntimeException {

    public CodeSandboxException() {
    }

    public CodeSandboxException(String message) {
        super(message);
    }

    public CodeSandboxException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeSandboxException(Throwable cause) {
        super(cause);
    }

    public CodeSandboxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
