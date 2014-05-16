package edu.gemini.thread;

/**
 *
 * @author ASaburov
 */
public class Manager {

    public static final int COUNT = 10;
    //
    private int contents;

    public synchronized int get() {
        System.out.println("GET");
        try {
            System.out.println("WAIT for GET");
            wait();
        } catch (InterruptedException e) {
        }

        System.out.println("Consumer got: " + contents);
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        System.out.println("PUT");
        try {
            System.out.println("WAIT for PUT");
            wait();
        } catch (InterruptedException e) {
        }
        
        System.out.println("Producer put: " + value);
        contents = value;
        notifyAll();
    }
}

