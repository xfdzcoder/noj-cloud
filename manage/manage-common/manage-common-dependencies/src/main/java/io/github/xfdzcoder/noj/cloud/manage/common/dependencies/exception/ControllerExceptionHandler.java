package io.github.xfdzcoder.noj.cloud.manage.common.dependencies.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xfdzcoder
 */

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response<String> exception(Exception e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return Response.fail("系统异常，请稍后重试");
    }

}
