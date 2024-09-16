package io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.exception;

/**
 * @author xfdzcoder
 */
public class SparkException extends RuntimeException {

    public SparkException() {
    }

    public SparkException(String message) {
        super(message);
    }

    public SparkException(String message, Throwable cause) {
        super(message, cause);
    }

    public SparkException(Throwable cause) {
        super(cause);
    }

    public SparkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
