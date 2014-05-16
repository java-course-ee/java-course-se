package edu.gemini.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Более современный вариант синхронизации изменения переменной
 *
 * @author ASaburov
 */
public class NewAtomic {

    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }
}