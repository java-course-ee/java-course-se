package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class DeadLockSolutionExample {

    public static void main(String[] args) throws InterruptedException {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread worker1 = new Thread(new Worker1(lock1, lock2));
        Thread worker2 = new Thread(new Worker2(lock1, lock2));

        worker1.start();

        Thread.sleep(20);

        worker2.start();

    }

}
