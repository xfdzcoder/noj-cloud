package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

/**
 * @author: xfdzcoder
 */
public class CompilerException extends Exception {

    public CompilerException() {
    }

    public CompilerException(String message) {
        super(message);
    }

    public CompilerException(ClassNotFoundException e) {
        super(e);
    }
}
