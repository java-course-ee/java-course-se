package edu.javacourse.a.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().getName() + " is started");

        try {
            System.out.println("Worker " + Thread.currentThread().getName() + " is waiting for permission to start");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Worker " + Thread.currentThread().getName() + " begin to work");
    }
}
