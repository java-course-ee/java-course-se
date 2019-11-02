package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class VolatileExample {

    public static void main(String[] args) throws InterruptedException {

        SharedObject sharedObject = new SharedObject();

        Thread writer = new Thread(new WriteWorker(sharedObject));
        Thread reader = new Thread(new ReadWorker(sharedObject));

        reader.start();

        Thread.sleep(2000);

        writer.start();

    }

}
