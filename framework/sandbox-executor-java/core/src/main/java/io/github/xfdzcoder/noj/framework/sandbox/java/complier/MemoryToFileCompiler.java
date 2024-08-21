package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

import javax.tools.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 自定义编译器，将存储在 {@link String} 中的源代码编译为 {@code byte[]}。可以直接通过 {@link ByteArrayClassLoader} 进行加载
 *
 * @author: xfdzcoder
 * @see JavaCompiler
 * @see JavaFileObject
 * @see SimpleJavaFileObject
 * @see ForwardingFileObject
 * @see DiagnosticCollector
 * @see java.io.ByteArrayOutputStream
 * @see StandardJavaFileManager
 * @see com.sun.tools.javac.jvm.ClassWriter#writeClass(Symbol.ClassSymbol)
 */
public class MemoryToFileCompiler implements Compiler {

    private static final JavaCompiler COMPILER = ToolProvider.getSystemJavaCompiler();

    @Override
    public byte[] compiler(String packageName, String className, String code, Iterable<String> options) throws CompilerException {
        if (packageName == null || className == null || code == null) {
            throw new NullPointerException("packageName or className or code is null");
        }

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        if (!packageName.isEmpty()) {
            code = "package " + packageName + ";" + code;
        }

        StringSourceFileObject fileObject = new StringSourceFileObject(className, code);
        JavaCompiler.CompilationTask task = COMPILER.getTask(
                null,
                new StringSourceFileManager(),
                diagnostics,
                options,
                null,
                Collections.singleton(fileObject)
        );

        if (task.call()) {
            return fileObject.getByteCode();
        } else {
            List<Diagnostic<? extends JavaFileObject>> diagnosticList = diagnostics.getDiagnostics();
            String errorMessage = diagnosticList.stream().map(Object::toString).collect(Collectors.joining("\n"));
            throw new CompilerException(errorMessage);
        }
    }
}
