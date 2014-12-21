package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker1 implements Runnable {

    private Lock lock1;
    private Lock lock2;

    public Worker1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println("Trying to lock lock1 from Worker1...");
        boolean isLockedLock1 = false;

        while (!isLockedLock1) {
            try {
                isLockedLock1 = lock1.tryLock(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        {
            System.out.println("lock1 from Worker1 has been locked");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\tTrying to lock lock2 from Worker1...");
            boolean isLockedLock2 = false;

            while (!isLockedLock2) {
                try {
                    isLockedLock2 = lock2.tryLock(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            {
                System.out.println("\tlock2 from Worker1 has been locked");
                System.out.println("\t\tPerforming some logic in Worker1 with lock1, lock2");
            }
            lock2.unlock();
            System.out.println("\tlock2 has been released from Worker1");
        }
        lock1.unlock();
        System.out.println("lock1 has been released from Worker1");
    }
}
