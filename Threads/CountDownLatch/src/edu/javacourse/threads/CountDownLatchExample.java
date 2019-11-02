package edu.javacourse.a.threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        CountDownLatch latch = new CountDownLatch(4);

        Thread worker1 = new Thread(new Worker(latch), "worker1");
        Thread worker2 = new Thread(new Worker(latch), "worker2");
        Thread worker3 = new Thread(new Worker(latch), "worker3");

        worker1.start();
        worker2.start();
        worker3.start();

        Thread.sleep(2000);

        System.out.println("Countdown begin:");

        for (int i = 1; i < 5; i++) {

            latch.countDown();
            System.out.println("Countdown: " + i);

            if (i < 4) Thread.sleep(random.nextInt(2000));
        }

        System.out.println("Countdown stopped");

    }

}
