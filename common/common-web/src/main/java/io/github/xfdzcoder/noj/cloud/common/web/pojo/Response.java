package io.github.xfdzcoder.noj.cloud.common.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应对象
 *
 * @author: Ding
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    /**
     * 响应码
     */
    private ResponseCode code;

    /**
     * 响应对象
     */
    private T data;

    /**
     * 响应消息，会提供给前端以供展示
     */
    private String message;

    public static <T> Response<T> ok() {
        return ok(null);
    }

    public static <T> Response<T> ok(T data) {
        return ok(data, "");
    }

    public static <T> Response<T> ok(T data, String message) {
        return create(ResponseCode.OK, data, message);
    }

    public static <T> Response<T> fail() {
        return fail(null);
    }

    public static <T> Response<T> fail(T data) {
        return fail(data, "");
    }

    public static <T> Response<T> fail(String message) {
        return fail(null, message);
    }

    public static <T> Response<T> fail(T data, String message) {
        return create(ResponseCode.FAIL, data, message);
    }

    public static <T> Response<T> create(ResponseCode code, String message) {
        return create(code, null, message);
    }

    public static <T> Response<T> create(ResponseCode code, T data, String message) {
        return new Response<>(code, data, message);
    }
}
