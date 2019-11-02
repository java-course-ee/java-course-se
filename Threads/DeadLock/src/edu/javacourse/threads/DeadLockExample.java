package edu.javacourse.a.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class DeadLockExample {

    public static void main(String[] args) throws InterruptedException {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread worker1 = new Thread(new Worker1(lock1, lock2));
        Thread worker2 = new Thread(new Worker2(lock1, lock2));

        worker1.start();

        Thread.sleep(20);

        worker2.start();

    }

}
