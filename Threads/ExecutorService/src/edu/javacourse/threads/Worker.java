package edu.javacourse.a.threads;

import java.util.Random;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Worker implements Runnable {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Therad " + name + " begin");
        for (int i = 0; i < 5; i++) {
            System.out.println("\tTherad " + name + " is working: " + i);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Therad " + name + " end");
    }
}
