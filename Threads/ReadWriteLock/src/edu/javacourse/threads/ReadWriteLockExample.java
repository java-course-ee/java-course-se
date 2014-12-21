package edu.javacourse.threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ReadWriteLockExample {

    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread reader1 = new Thread(new Reader(lock), "reader1");
        Thread reader2 = new Thread(new Reader(lock), "reader2");
        Thread reader3 = new Thread(new Reader(lock), "reader3");

        Thread writer1 = new Thread(new Writer(lock), "writer1");
        Thread writer2 = new Thread(new Writer(lock), "writer2");

        reader1.start();
        reader2.start();
        reader3.start();

        writer1.start();
        writer2.start();

    }

}
