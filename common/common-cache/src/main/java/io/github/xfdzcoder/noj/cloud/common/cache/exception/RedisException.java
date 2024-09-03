package io.github.xfdzcoder.noj.cloud.common.cache.exception;


/**
 * @author Ding
 */
public class RedisException extends RuntimeException {

    public RedisException() {
        super();
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedisException(Throwable cause) {
        super(cause);
    }

}
