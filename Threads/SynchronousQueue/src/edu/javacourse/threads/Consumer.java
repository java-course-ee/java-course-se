package edu.javacourse.threads;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Consumer implements Runnable {

    private SynchronousQueue<Integer> queue;

    public Consumer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            final Integer num;
            try {
                System.out.println("Consumer about to get");
                num = queue.take();
                System.out.println("Consumer get: " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
