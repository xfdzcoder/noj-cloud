package io.github.xfdzcoder.noj.cloud.sandbox.utils.compiler;


import lombok.Getter;

/**
 * 退出类型。
 *
 * @author: xfdzcoder
 */

@Getter
public enum ExitTypeEnum {

    NO_PERMISSION(-1, "权限不足"),

    NORMAL(0, "正常退出"),

    COMPILE_ERROR(1, "编译错误"),

    RUN_ERROR(2, "运行错误"),

    TIMEOUT(3, "超时"),

    MEMORY_OVERFLOW(4, "内存超限")

    ;

    private final int code;

    private final String message;

    ExitTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
