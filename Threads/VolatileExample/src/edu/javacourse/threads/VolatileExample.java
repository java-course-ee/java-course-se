package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class VolatileExample {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);

        thread.start();

        Thread.sleep(2000);

        worker.die();
    }

}
