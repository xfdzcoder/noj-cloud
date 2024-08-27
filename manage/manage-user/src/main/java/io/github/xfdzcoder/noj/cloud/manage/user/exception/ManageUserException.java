package io.github.xfdzcoder.noj.cloud.manage.user.exception;

/**
 * @author xfdzcoder
 */

// TODO 2024/8/27 12:44 on dev-xfdzcoder: 统一服务根异常
public class ManageUserException extends RuntimeException {

    public ManageUserException() {
    }

    public ManageUserException(String message) {
        super(message);
    }

    public ManageUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManageUserException(Throwable cause) {
        super(cause);
    }

    public ManageUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
