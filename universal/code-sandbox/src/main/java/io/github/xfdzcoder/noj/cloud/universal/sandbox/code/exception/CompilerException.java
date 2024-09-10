package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.exception;

import java.io.IOException;

/**
 * @author xfdzcoder
 */
public class CompilerException extends IOException {

    public CompilerException() {
    }

    public CompilerException(String message) {
        super(message);
    }

    public CompilerException(Exception e) {
        super(e);
    }
}
