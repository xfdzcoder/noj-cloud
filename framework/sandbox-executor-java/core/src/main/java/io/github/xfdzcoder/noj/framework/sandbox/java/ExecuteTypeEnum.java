package io.github.xfdzcoder.noj.framework.sandbox.java;

/**
 * 执行类型，支持 ACM 模式和 核心方法模式
 *
 * @author: xfdzcoder
 */
public enum ExecuteTypeEnum {

    ACM(true),

    CORE_METHOD(false)

    ;

    private final boolean mode;

    ExecuteTypeEnum(boolean mode) {
        this.mode = mode;
    }

    public boolean getMode() {
        return mode;
    }

    public boolean isAcm() {
        return this == ACM;
    }

    public boolean isCoreMethod() {
        return this == CORE_METHOD;
    }
}
