package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

/**
 * 编译接口
 *
 * @author: xfdzcoder
 */
public interface Compiler {


    byte[] compiler(String packageName, String className, String code, Iterable<String> options) throws CompilerException;

}
