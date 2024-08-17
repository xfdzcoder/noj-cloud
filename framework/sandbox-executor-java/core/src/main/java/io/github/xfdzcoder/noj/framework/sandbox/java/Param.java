package io.github.xfdzcoder.noj.framework.sandbox.java;

import java.util.List;
import java.util.Map;

/**
 * 执行信息，包含了参数和响应信息
 *
 * @author: xfdzcoder
 */

public class Param<I, O> {

    /** 唯一标识 */
    private String identify;

    /** 代码文本 */
    private String code;

    private List<InputOutput<I, O>> inputOutputList;

    /** 时间限制，单位毫秒 */
    private int timeout;

    /** 内存限制，单位 MB */
    private int memory;

    /** 执行模式 */
    private ExecuteTypeEnum type;

    /** 自定义扩展参数 */
    private Map<Object, Object> extraParam;

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<InputOutput<I, O>> getInputOutputList() {
        return inputOutputList;
    }

    public void setInputOutputList(List<InputOutput<I, O>> inputOutputList) {
        this.inputOutputList = inputOutputList;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public ExecuteTypeEnum getType() {
        return type;
    }

    public void setType(ExecuteTypeEnum type) {
        this.type = type;
    }

    public Map<Object, Object> getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(Map<Object, Object> extraParam) {
        this.extraParam = extraParam;
    }
}
