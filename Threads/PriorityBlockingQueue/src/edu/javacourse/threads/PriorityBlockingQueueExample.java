package edu.javacourse.threads;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class PriorityBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        QueueEntry entry1 = new QueueEntry(1, "entry1");
        QueueEntry entry2 = new QueueEntry(2, "entry2");
        QueueEntry entry3 = new QueueEntry(3, "entry3");
        QueueEntry entry4 = new QueueEntry(4, "entry4");
        QueueEntry entry5 = new QueueEntry(5, "entry5");
        QueueEntry entry6 = new QueueEntry(6, "entry6");

        PriorityBlockingQueue<QueueEntry> queue = new PriorityBlockingQueue<>(10);

        Thread worker1 = new Thread(new Worker(queue), "worker1");
        Thread worker2 = new Thread(new Worker(queue), "worker2");
        worker1.start();
        worker2.start();

        Thread.sleep(1000);

        queue.add(entry3);
        queue.add(entry1);
        queue.add(entry5);
        queue.add(entry4);
        queue.add(entry2);
        queue.add(entry6);

        Thread.sleep(7000);

        System.out.println();
        System.out.println();

        queue.add(entry3);
        queue.add(entry1);
        queue.add(entry5);
        queue.add(entry4);
        queue.add(entry2);
        queue.add(entry6);

        Thread.sleep(2000);

        worker1.interrupt();
        worker2.interrupt();

    }

}
