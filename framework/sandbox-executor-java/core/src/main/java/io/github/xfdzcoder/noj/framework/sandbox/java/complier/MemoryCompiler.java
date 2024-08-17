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
public class MemoryCompiler implements Compiler {

    private static final JavaCompiler COMPILER = ToolProvider.getSystemJavaCompiler();

    private static final ByteArrayClassLoader CLASS_LOADER = new ByteArrayClassLoader();

    @Override
    public boolean canCompiler(String packageName, String className, String code, Iterable<String> options) {
        return true;
    }

    @Override
    public Class<?> compiler(String code) throws CompilerException {
        return compiler(code, null);
    }

    @Override
    public Class<?> compiler(String code, Iterable<String> options) throws CompilerException {
        return compiler(null, "Main", code, options);
    }

    @Override
    public Class<?> compiler(String className, String code, Iterable<String> options) throws CompilerException {
        return compiler("sandbox", className, code, options);
    }

    @Override
    public Class<?> compiler(String packageName, String className, String code, Iterable<String> options) throws CompilerException {
        try {
            if (packageName == null || className == null || code == null) {
                throw new NullPointerException("packageName or className or code is null");
            }

            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            if (!packageName.isEmpty()) {
                code = "package " + packageName + ";" + code;
            }

            StringSourceFileObject fileObject = new StringSourceFileObject(packageName, className, code);
            JavaCompiler.CompilationTask task = COMPILER.getTask(
                    null,
                    new StringSourceFileManager(),
                    diagnostics,
                    options,
                    null,
                    Collections.singleton(fileObject)
            );

            if (task.call()) {
                return CLASS_LOADER.loadClassFromByteArray(fileObject.getFullClassName(), fileObject.getByteCode());
            } else {
                List<Diagnostic<? extends JavaFileObject>> diagnosticList = diagnostics.getDiagnostics();
                String errorMessage = diagnosticList.stream().map(Object::toString).collect(Collectors.joining("\n"));
                throw new CompilerException(errorMessage);
            }
        } catch (ClassNotFoundException e) {
            throw new CompilerException(e);
        }
    }
}
