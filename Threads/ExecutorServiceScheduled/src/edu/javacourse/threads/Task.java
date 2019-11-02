package edu.javacourse.a.threads;

import java.util.Date;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Task is executed in " + ExecutorServiceScheduledExample.dateFormatter.format(new Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
