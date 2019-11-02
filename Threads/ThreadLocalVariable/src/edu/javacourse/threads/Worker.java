package edu.javacourse.a.threads;

import java.util.Random;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private ThreadLocal<String> threadLocal;
    private String workerString;

    public Worker(ThreadLocal<String> threadLocal, String workerString) {
        this.threadLocal = threadLocal;
        this.workerString = workerString;
    }

    @Override
    public void run() {
        threadLocal.set(workerString);

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ThreadLocal value from " + workerString + " thread: " + threadLocal.get());
    }
}
