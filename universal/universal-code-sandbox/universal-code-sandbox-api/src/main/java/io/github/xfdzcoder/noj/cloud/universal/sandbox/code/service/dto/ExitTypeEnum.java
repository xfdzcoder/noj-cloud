package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto;

import lombok.Getter;

@Getter
public enum ExitTypeEnum {

    NO_PERMISSION(-1, "权限不足"),

    NORMAL(0, "正常退出"),

    COMPILE_ERROR(1, "编译错误"),

    RUN_ERROR(2, "运行错误"),

    TIMEOUT(3, "超时"),

    MEMORY_OVERFLOW(4, "内存超限"),

    /**
     * 此类型的报错信息不应该暴露给前端
     */
    SYSTEM_ERROR(5, "系统错误，请检查日志");

    private final int code;

    private final String message;

    ExitTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(Integer code) {
        return switch (code) {
            case -1 -> NO_PERMISSION.getMessage();
            case 0 -> NORMAL.getMessage();
            case 1 -> COMPILE_ERROR.getMessage();
            case 3 -> TIMEOUT.getMessage();
            case 4 -> MEMORY_OVERFLOW.getMessage();
            case null, default -> RUN_ERROR.getMessage();
        };
    }
}