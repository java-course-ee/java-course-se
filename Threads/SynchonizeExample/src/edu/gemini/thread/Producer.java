package edu.gemini.thread;

/**
 * Класс демонстрирует обращение к методу
 * в синхронизированном и несинхронизированном режиме
 */
public class Producer {

    // Метод несинхронизирован, значит будет вызываться сразу всеми
    // объектами Consumer
    public void callAsynchronous(String consumerName) {
        System.out.println("Aynchronous START:" + consumerName);
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
        }
        System.out.println("Aynchronous FINISH:" + consumerName);
    }

    // Метод синхронизирован. Pначит будет вызываться поочередно
    // объектами Consumer
    public synchronized void callSynchronous(String consumerName) {
        System.out.println("Synchronous START:" + consumerName);
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
        }
        System.out.println("Synchronous FINISH:" + consumerName);
    }
}
