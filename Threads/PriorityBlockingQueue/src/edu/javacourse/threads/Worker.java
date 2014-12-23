package edu.javacourse.threads;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private PriorityBlockingQueue<QueueEntry> queue;

    public Worker(PriorityBlockingQueue<QueueEntry> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Worker " + Thread.currentThread().getName() + " is awaiting for entries...");
                QueueEntry entry = queue.take();
                System.out.println("Worker " + Thread.currentThread().getName() + " get entry with id: " + entry.getId() + ", name: " + entry.getName());
            } catch (InterruptedException e) {
                return;
            }

            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
