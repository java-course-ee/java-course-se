package edu.gemini.concurrency;

/**
 * Простой вариант синхронизации изменения переменной
 * 
 * @author ASaburov
 */
public class OldAtomic {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}