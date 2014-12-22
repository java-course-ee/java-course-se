package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker1 implements Runnable {

    private Object lock1;
    private Object lock2;

    public Worker1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println("Trying to lock lock1 from Worker1...");
        synchronized (lock1) {
            System.out.println("lock1 from Worker1 has been locked");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\tTrying to lock lock2 from Worker1...");
            synchronized (lock2) {
                System.out.println("\tlock2 from Worker1 has been locked");
                System.out.println("\t\tPerforming some logic in Worker1 with lock1, lock2");
            }
            System.out.println("\tlock2 has been released from Worker1");
        }
        System.out.println("lock1 has been released from Worker1");
    }
}
