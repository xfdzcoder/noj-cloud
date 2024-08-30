package io.github.xfdzcoder.noj.cloud.manage.common.dependencies.exception;

import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xfdzcoder
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response<String> exception(Exception e) {
        return Response.fail(e.getMessage());
    }

}
