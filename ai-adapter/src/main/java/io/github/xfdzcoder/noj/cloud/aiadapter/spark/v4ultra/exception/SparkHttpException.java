package io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.exception;

import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpRequest;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpResponse;
import lombok.Getter;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author xfdzcoder
 */

@Getter
public class SparkHttpException extends SparkException {

    private HttpRequest request;

    private ClientHttpResponse response;

    private ResponseEntity<SparkHttpResponse> responseEntity;

    private SparkHttpRequest body;

    public SparkHttpException() {
    }

    public SparkHttpException(String message) {
        super(message);
    }

    public SparkHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public SparkHttpException(Throwable cause) {
        super(cause);
    }

    public SparkHttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SparkHttpException(String message, HttpRequest req, ClientHttpResponse resp, SparkHttpRequest body) {
        super(message);
        this.request = req;
        this.response = resp;
        this.body = body;
    }

    public SparkHttpException(String message, SparkHttpRequest body, ResponseEntity<SparkHttpResponse> responseEntity) {
        super(message);
        this.body = body;
        this.responseEntity = responseEntity;
    }
}
