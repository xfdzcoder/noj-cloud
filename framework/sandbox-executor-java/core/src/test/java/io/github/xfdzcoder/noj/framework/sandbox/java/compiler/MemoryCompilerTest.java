package io.github.xfdzcoder.noj.framework.sandbox.java.compiler;

import io.github.xfdzcoder.noj.framework.sandbox.java.complier.CompilerException;
import io.github.xfdzcoder.noj.framework.sandbox.java.complier.MemoryCompiler;
import org.junit.Test;

import java.util.Collections;

/**
 * @author: xfdzcoder
 */
public class MemoryCompilerTest {

    @Test
    public void test() {

        String code = """
                public class Main {
                    public static void main(String[] args) {
                        System.out.println("Hello World %d !");
                    }
                }
                """;

        try {
            new MemoryCompiler().compiler("a", "Main", code, Collections.singleton("-proc:none"));
        } catch (CompilerException e) {
            throw new RuntimeException(e);
        }
    }

}
