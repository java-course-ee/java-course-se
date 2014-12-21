package threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker2 implements Runnable {

    private Lock lock1;
    private Lock lock2;

    public Worker2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println("Trying to lock lock2 from Worker2...");
        boolean isLockedLock2 = false;

        while (!isLockedLock2) {
            try {
                isLockedLock2 = lock2.tryLock(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        {
            System.out.println("lock2 from Worker2 has been locked");
            System.out.println("\tTrying to lock lock1 from Worker2...");
            boolean isLockedLock1 = false;

            while (!isLockedLock1) {
                try {
                    isLockedLock1 = lock1.tryLock(10, TimeUnit.MILLISECONDS);
                    if (!isLockedLock1) {
                        // revert changes made by this method
                        lock2.unlock();
                        Thread.sleep(new Random().nextInt(100));
                        run();
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            {
                System.out.println("\tlock1 from Worker2 has been locked");
                System.out.println("\t\tPerforming some logic in Worker2 with lock2, lock1");
            }
            lock1.unlock();
            System.out.println("\tlock1 has been released from Worker2");
        }
        lock2.unlock();
        System.out.println("lock2 has been released from Worker2");
    }
}
