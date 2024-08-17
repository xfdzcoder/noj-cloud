package io.github.xfdzcoder.noj.framework.sandbox.java.complier;

/**
 * 字节数组类加载器
 *
 * @author: xfdzcoder
 */
public final class ByteArrayClassLoader extends ClassLoader {

    static {
        registerAsParallelCapable();
    }

    Class<?> loadClassFromByteArray(String name, byte[] byteCode) throws ClassNotFoundException {
        if (name == null || byteCode == null || name.isEmpty() || byteCode.length == 0) {
            throw new ClassNotFoundException("name or byteCode is null or empty");
        }
        synchronized (getClassLoadingLock(name)) {
            return defineClass(name, byteCode, 0, byteCode.length);
        }
    }
}
