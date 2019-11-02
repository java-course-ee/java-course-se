package edu.javacourse.a.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class WriteWorker implements Runnable {

    private SharedObject sharedObject;

    public WriteWorker(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("write: " + i);
            sharedObject.counter = i;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
