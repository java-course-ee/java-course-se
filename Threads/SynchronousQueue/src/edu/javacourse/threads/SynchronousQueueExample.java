package edu.javacourse.threads;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class SynchronousQueueExample {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(false);

        Thread producer1 = new Thread(new Producer(queue), "producer1");
        Thread producer2 = new Thread(new Producer(queue), "producer2");

        Thread consumer = new Thread(new Consumer(queue), "consumer");

        consumer.start();

        producer1.start();
        producer2.start();
    }

}
