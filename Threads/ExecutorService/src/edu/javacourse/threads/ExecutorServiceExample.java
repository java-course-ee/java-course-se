package edu.javacourse.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {

        Worker worker1 = new Worker("worker1");
        Worker worker2 = new Worker("worker2");
        Worker worker3 = new Worker("worker3");
        Worker worker4 = new Worker("worker4");
        Worker worker5 = new Worker("worker5");

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
