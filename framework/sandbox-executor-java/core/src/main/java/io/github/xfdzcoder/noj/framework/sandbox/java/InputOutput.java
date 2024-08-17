package io.github.xfdzcoder.noj.framework.sandbox.java;

/**
 * 输入输出
 *
 * @author: xfdzcoder
 */

public class InputOutput<I, O> {

    private I input;

    private O output;

    public I getInput() {
        return input;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public O getOutput() {
        return output;
    }

    public void setOutput(O output) {
        this.output = output;
    }
}
