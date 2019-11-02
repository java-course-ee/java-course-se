package edu.javacourse.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ExecutorServiceScheduledExample {

    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {

        Task task1 = new Task();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        System.out.println("Starting scheduled tasks at " + dateFormatter.format(new Date()));

        {
            System.out.println("Scheduling task for running at fixed time since now...");
            executorService.schedule(task1, 5000, TimeUnit.MILLISECONDS);
        }

//        {
//            System.out.println("Scheduling task for running at fixed time since start of executing of previous thread...");
//            executorService.scheduleAtFixedRate(task1, 0, 2000, TimeUnit.MILLISECONDS);
//        }

//        {
//            System.out.println("Scheduling task for running at fixed time since end of executing of previous thread...");
//            executorService.scheduleWithFixedDelay(task1, 0, 2000, TimeUnit.MILLISECONDS);
//        }

        Thread.sleep(20000);

        System.out.println("Stopping scheduling of tasks at " + dateFormatter.format(new Date()));
        executorService.shutdown();

    }

}
