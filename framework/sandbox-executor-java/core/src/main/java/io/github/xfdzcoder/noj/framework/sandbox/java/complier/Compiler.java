package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

/**
 * 编译接口
 *
 * @author: xfdzcoder
 */
public interface Compiler {

    boolean canCompiler(String packageName, String className, String code, Iterable<String> options);

    Class<?> compiler(String packageName, String className, String code, Iterable<String> options) throws CompilerException;

    Class<?> compiler(String className, String code, Iterable<String> options) throws CompilerException;

    Class<?> compiler(String code, Iterable<String> options) throws CompilerException;

    Class<?> compiler(String code) throws CompilerException;

}
