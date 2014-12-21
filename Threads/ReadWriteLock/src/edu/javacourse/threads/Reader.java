package edu.javacourse.threads;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Reader implements Runnable {

    private ReadWriteLock lock;

    public Reader(ReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.readLock().lock();
            System.out.println("Thread " + Thread.currentThread().getName() + " got lock");

            System.out.println("\tThread " + Thread.currentThread().getName() + ": Shared data: " + SharedData.i);

            try {
                Thread.sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread " + Thread.currentThread().getName() + " releasing read lock");
            lock.readLock().unlock();
        }
    }
}
