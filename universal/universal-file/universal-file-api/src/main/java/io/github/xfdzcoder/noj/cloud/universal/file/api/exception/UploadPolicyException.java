package io.github.xfdzcoder.noj.cloud.universal.file.api.exception;

/**
 * @author xfdzcoder
 */
public class UploadPolicyException extends UniversalFileException {

    public UploadPolicyException() {
    }

    public UploadPolicyException(String message) {
        super(message);
    }

    public UploadPolicyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadPolicyException(Throwable cause) {
        super(cause);
    }
}
