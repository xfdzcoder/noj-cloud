package io.github.xfdzcoder.noj.cloud.common.dao.web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 定义统一的响应码。
 *
 * @author: Ding
 */


@Getter
public enum ResponseCode {

    /**
     * 请求完全成功
     */
    OK("20000", "成功"),

    /**
     * 请求出现异常。
     */
    FAIL("50000", "服务器异常"),

    /**
     * 权限不足
     */
    NO_PERMISSION("40001", "权限不足");

    /**
     * 响应码，这个字段会被返回给前端
     */
    @JsonValue
    private final String code;

    /**
     * 备注，不返回给前端，仅在后端用作备注
     */
    private final String remark;

    ResponseCode(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }
}
