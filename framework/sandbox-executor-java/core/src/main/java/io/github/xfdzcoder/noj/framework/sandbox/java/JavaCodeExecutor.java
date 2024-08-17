package io.github.xfdzcoder.noj.framework.sandbox.java;

import io.github.xfdzcoder.noj.framework.sandbox.java.executor.ExecuteException;

/**
 * Java 代码执行器
 *
 * @author: xfdzcoder
 */
public interface JavaCodeExecutor {

    <I, O> Result<I, O> execute(Param<I, O> param);

    <I, O> Result<I, O> executeAcm(Class<?> clz, Param<I, O> param) throws ExecuteException;

    <I, O> Result<I, O> executeCoreMethod(Class<?> clz, Param<I, O> param);

}
