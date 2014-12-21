package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private volatile boolean isAlive = true;
//    private boolean isAlive = true;

    @Override
    public void run() {
        boolean isAliveLocal = isAlive;
        while (isAliveLocal) {
            if (isAliveLocal != isAlive) {
                System.out.println("changed");
                isAliveLocal = isAlive;
            }
        }
    }

    public void die() {
        System.out.println("die signal");
        isAlive = false;
    }
}
