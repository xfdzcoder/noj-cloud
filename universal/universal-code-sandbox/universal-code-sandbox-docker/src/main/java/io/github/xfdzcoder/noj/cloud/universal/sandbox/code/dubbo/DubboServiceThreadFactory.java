package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.dubbo;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xfdzcoder
 */

public class DubboServiceThreadFactory implements ThreadFactory {

    private final String prefix;

    private final ThreadGroup group;

    private final AtomicInteger threadId = new AtomicInteger(0);

    private static final AtomicInteger factoryId = new AtomicInteger(0);

    public DubboServiceThreadFactory(String prefix) {
        this.group = new ThreadGroup(Thread.currentThread().getThreadGroup(), "Custom-DubboService-" + factoryId.incrementAndGet());
        this.prefix = "Dubbo-" + prefix + "-";
    }


    @Override
    public Thread newThread(Runnable r) {
        Objects.requireNonNull(r, "runnable is null");
        Thread thread = new Thread(group, r);
        thread.setName(prefix + "[#" + threadId.incrementAndGet() + "]");
        return thread;
    }
}
