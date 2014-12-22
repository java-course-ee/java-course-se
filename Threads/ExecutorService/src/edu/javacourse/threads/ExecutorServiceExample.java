package edu.javacourse.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {

        Thread worker1 = new Thread(new Worker("worker1"));
        Thread worker2 = new Thread(new Worker("worker2"));
        Thread worker3 = new Thread(new Worker("worker3"));
        Thread worker4 = new Thread(new Worker("worker4"));
        Thread worker5 = new Thread(new Worker("worker5"));

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(worker1);
        executorService.execute(worker2);
        executorService.execute(worker3);
        executorService.execute(worker4);
        executorService.execute(worker5);

        executorService.shutdown();

    }

}
