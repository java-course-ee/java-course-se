package edu.javacourse.threads;

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

        for (int i = 0; i < 5; i++) {
            System.out.println("Therad " + name + " is working: " + i);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
