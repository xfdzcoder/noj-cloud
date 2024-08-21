package io.github.xfdzcoder.noj.cloud.sandbox.utils.compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.CharBuffer;

/**
 * 它表示存储在字符串中的源代码
 *
 * @author: xfdzcoder
 */
public class StringSourceFileObject extends SimpleJavaFileObject {

    private final String fullClassName;

    /**
     * 源代码
     */
    private final String code;

    private byte[] byteCode;

    public StringSourceFileObject(String className, String code) {
        super(parse(className), Kind.SOURCE);
        this.code = code;
        this.fullClassName = className;
    }

    private static URI parse(String className) {
        return URI.create("string:///" + className + Kind.SOURCE.extension);
    }

    public byte[] getByteCode() {
        return byteCode == null || byteCode.length == 0 ? null : byteCode;
    }

    public String getFullClassName() {
        return fullClassName == null || fullClassName.isEmpty() ? null : fullClassName;
    }

    @Override
    public CharBuffer getCharContent(boolean ignoreEncodingErrors) {
        return CharBuffer.wrap(code);
    }

    @Override
    public OutputStream openOutputStream() {
        return new FilterOutputStream(new ByteArrayOutputStream()) {
            @Override
            public void close() throws IOException {
                ByteArrayOutputStream byteCodeStream = (ByteArrayOutputStream) out;
                byteCode = byteCodeStream.toByteArray();
                out.close();
            }
        };
    }

    @Override
    public String getName() {
        return "Line";
    }
}
