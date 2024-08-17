package io.github.xfdzcoder.noj.framework.sandbox.java;

/**
 * 执行结果
 *
 * @author: xfdzcoder
 */

public class Result<I, O> {

    /** 是否执行成功 */
    private boolean succeed;

    private I input;

    /** 错误输出 */
    private Object output;

    /** 期望输出 */
    private O exceptOutput;

    private int avgTime;

    private int avgMemory;

    private int passedCaseCount;

    private int totalCaseCount;

    private String throwableOutput;

    private ExitTypeEnum exitType;

    public Result(ExitTypeEnum exitType) {
        this.exitType = exitType;
    }

    public static <I, O> ResultBuilder<I, O> builder() {
        return new ResultBuilder<>();
    }

    public boolean isSucceed() {
        return this.succeed;
    }

    public I getInput() {
        return this.input;
    }

    public Object getOutput() {
        return this.output;
    }

    public O getExceptOutput() {
        return this.exceptOutput;
    }

    public int getAvgTime() {
        return this.avgTime;
    }

    public int getAvgMemory() {
        return this.avgMemory;
    }

    public int getPassedCaseCount() {
        return this.passedCaseCount;
    }

    public int getTotalCaseCount() {
        return this.totalCaseCount;
    }

    public String getThrowableOutput() {
        return this.throwableOutput;
    }

    public ExitTypeEnum getExitType() {
        return this.exitType;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public void setExceptOutput(O exceptOutput) {
        this.exceptOutput = exceptOutput;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    public void setAvgMemory(int avgMemory) {
        this.avgMemory = avgMemory;
    }

    public void setPassedCaseCount(int passedCaseCount) {
        this.passedCaseCount = passedCaseCount;
    }

    public void setTotalCaseCount(int totalCaseCount) {
        this.totalCaseCount = totalCaseCount;
    }

    public void setThrowableOutput(String throwableOutput) {
        this.throwableOutput = throwableOutput;
    }

    public void setExitType(ExitTypeEnum exitType) {
        this.exitType = exitType;
    }

    public Result(boolean succeed, I input, Object output, O exceptOutput, int avgTime, int avgMemory, int passedCaseCount, int totalCaseCount, String throwableOutput, ExitTypeEnum exitType) {
        this.succeed = succeed;
        this.input = input;
        this.output = output;
        this.exceptOutput = exceptOutput;
        this.avgTime = avgTime;
        this.avgMemory = avgMemory;
        this.passedCaseCount = passedCaseCount;
        this.totalCaseCount = totalCaseCount;
        this.throwableOutput = throwableOutput;
        this.exitType = exitType;
    }

    public static class ResultBuilder<I, O> {
        private boolean succeed;
        private I input;
        private Object output;
        private O exceptOutput;
        private int avgTime;
        private int avgMemory;
        private int passedCaseCount;
        private int totalCaseCount;
        private String throwableOutput;
        private ExitTypeEnum exitType;

        ResultBuilder() {
        }

        public ResultBuilder<I, O> succeed(boolean succeed) {
            this.succeed = succeed;
            return this;
        }

        public ResultBuilder<I, O> input(I input) {
            this.input = input;
            return this;
        }

        public ResultBuilder<I, O> output(Object output) {
            this.output = output;
            return this;
        }

        public ResultBuilder<I, O> exceptOutput(O exceptOutput) {
            this.exceptOutput = exceptOutput;
            return this;
        }

        public ResultBuilder<I, O> avgTime(int avgTime) {
            this.avgTime = avgTime;
            return this;
        }

        public ResultBuilder<I, O> avgMemory(int avgMemory) {
            this.avgMemory = avgMemory;
            return this;
        }

        public ResultBuilder<I, O> passedCaseCount(int passedCaseCount) {
            this.passedCaseCount = passedCaseCount;
            return this;
        }

        public ResultBuilder<I, O> totalCaseCount(int totalCaseCount) {
            this.totalCaseCount = totalCaseCount;
            return this;
        }

        public ResultBuilder<I, O> throwableOutput(String throwableOutput) {
            this.throwableOutput = throwableOutput;
            return this;
        }

        public ResultBuilder<I, O> exitType(ExitTypeEnum exitType) {
            this.exitType = exitType;
            return this;
        }

        public Result<I, O> build() {
            return new Result<>(this.succeed, this.input, this.output, this.exceptOutput, this.avgTime, this.avgMemory, this.passedCaseCount, this.totalCaseCount, this.throwableOutput, this.exitType);
        }
    }
}
