package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

import javax.tools.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 它管理存储在字符串中的源代码
 *
 * @author: xfdzcoder
 */
public class StringSourceFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {

    public StringSourceFileManager() {
        super(ToolProvider.getSystemJavaCompiler().getStandardFileManager(new DiagnosticCollector<>(), Locale.getDefault(), StandardCharsets.UTF_8));
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        if (kind == JavaFileObject.Kind.CLASS && sibling instanceof StringSourceFileObject sourceFileObject) {
            return sourceFileObject;
        }
        return super.getJavaFileForOutput(location, className, kind, sibling);
    }
}
