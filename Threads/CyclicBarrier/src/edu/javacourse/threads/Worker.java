package edu.javacourse.a.threads;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        Random random = new Random();
        final String threadName = "Thread " + Thread.currentThread().getName();

        System.out.println(threadName + " is starting work");

        for (int i = 0; i < 5; i++) {
            sleep(random.nextInt(5000));
            System.out.println(threadName + " in on phase " + i + " and will be waiting for others");
            awaitForAllOthers();
            System.out.println(threadName + " is continuing it's work");
        }

        System.out.println(threadName + " has ended work");
    }

    private void awaitForAllOthers() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void sleep(int random) {
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
