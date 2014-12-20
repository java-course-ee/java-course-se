package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private static final String died = "died";
//    private volatile boolean isAlive = true;
    private boolean isAlive = true;

    @Override
    public void run() {
        while (isAlive) {
            System.out.println(isAlive);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void die() {
        isAlive = false;
        System.out.println(died);
        System.out.println(isAlive);
    }
}
