package edu.javacourse.threads;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Writer implements Runnable {

    private ReadWriteLock lock;

    public Writer(ReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.writeLock().lock();
            System.out.println("\t\t\t\t===================================================");
            System.out.println("\t\t\t\tThread " + Thread.currentThread().getName() + " got lock");

            int newI = SharedData.i + 1;
            System.out.println("\t\t\t\t\tThread " + Thread.currentThread().getName() + ": Shared data changing to: " + newI);
            SharedData.i = newI;

            System.out.println("\t\t\t\tThread " + Thread.currentThread().getName() + " releasing write lock");
            System.out.println("\t\t\t\t===================================================");
            lock.writeLock().unlock();

            try {
                Thread.sleep(new Random().nextInt(40));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
