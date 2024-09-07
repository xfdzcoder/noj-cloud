package io.github.xfdzcoder.noj.cloud.universal.file.api.exception;

/**
 * @author xfdzcoder
 */
public class UniversalFileException extends RuntimeException{

    public UniversalFileException() {
    }

    public UniversalFileException(String message) {
        super(message);
    }

    public UniversalFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversalFileException(Throwable cause) {
        super(cause);
    }
}
