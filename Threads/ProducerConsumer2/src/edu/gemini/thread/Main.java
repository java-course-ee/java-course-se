package edu.gemini.thread;

/**
 *
 * @author ASaburov
 */
public class Main {

    public static void main(String[] args) {
        Manager c = new Manager();
        Producer p1 = new Producer(c);
        Consumer c1 = new Consumer(c);

        p1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        c1.start();

    }
}
