package edu.javacourse.a.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ReadWorker implements Runnable {

    private SharedObject sharedObject;

    public ReadWorker(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        int counter = sharedObject.counter;
        while (counter < 10) {
            if (counter != sharedObject.counter) {
                System.out.println("... changed.");
                counter = sharedObject.counter;
            }
        }
    }
}
