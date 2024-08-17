package io.github.xfdzcoder.noj.framework.sandbox.java;

import io.github.xfdzcoder.noj.framework.sandbox.java.executor.AbstractJavaExecutor;
import org.junit.Test;

/**
 * @author: xfdzcoder
 */


public class AbstractJavaExecutorTest {

    @Test
    public void testBlackWordList() {
        AbstractJavaExecutor executor = new AbstractJavaExecutor() {
            @Override
            public <I, O> Result<I, O> executeAcm(Param<I, O> param) {
                return null;
            }

            @Override
            public <I, O> Result<I, O> executeCoreMethod(Param<I, O> param) {
                return null;
            }
        };
    }

}
