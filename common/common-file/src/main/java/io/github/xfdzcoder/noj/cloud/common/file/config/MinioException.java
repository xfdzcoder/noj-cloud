package io.github.xfdzcoder.noj.cloud.common.file.config;

/**
 * @author xfdzcoder
 */
public class MinioException extends RuntimeException {

    public MinioException() {
    }

    public MinioException(String message) {
        super(message);
    }

    public MinioException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinioException(Throwable cause) {
        super(cause);
    }

    public MinioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}