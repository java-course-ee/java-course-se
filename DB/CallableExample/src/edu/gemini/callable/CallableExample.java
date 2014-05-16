package edu.gemini.callable;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Пример использования интерфейса Callable
 * 
 * @author ASaburov
 */
public class CallableExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable c = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("Inside 'call' 1");
                Thread.sleep(5000);
                System.out.println("Inside 'call' 2");
                return "Hello world!!!";
            }
        };

        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> answer = es.submit(c);
        System.out.println("After call 1 : " + new Date(System.currentTimeMillis()));
        Thread.sleep(2000);
        // Вызов isDone не блокирует выполнение потока
        System.out.println("Is done 1 : " + answer.isDone());
        // Этот вызов блокирует выполнение текущего потока до завершения задачи
        String hello = answer.get();
        System.out.println("After call 2 : " + new Date(System.currentTimeMillis()));
        System.out.println("Is done 2 : " + answer.isDone());
        System.out.println();
        System.out.println("Answer:" + hello);
        
        es.shutdown();
    }
}
