package edu.javacourse.a.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ThreadLocalVariableExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();

        Thread worker1 = new Thread(new Worker(threadLocal, "worker1"));
        Thread worker2 = new Thread(new Worker(threadLocal, "worker2"));
        Thread worker3 = new Thread(new Worker(threadLocal, "worker3"));

        worker1.start();
        worker2.start();
        worker3.start();
    }

}
