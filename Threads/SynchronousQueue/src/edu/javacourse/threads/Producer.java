package edu.javacourse.threads;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Producer implements Runnable {

    private SynchronousQueue<Integer> queue;

    public Producer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Producer " + Thread.currentThread().getName() + " about put: " + i);
                queue.put(i);
                System.out.println("Producer " + Thread.currentThread().getName() + " put: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
