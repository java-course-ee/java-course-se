package edu.gemini.thread;

/**
 * Класс обращается к ресурсу
 */
public class Consumer extends Thread {

    // Поле для хранения ссылки на ресурс
    private Producer producer;
    // Поле для хранения имени (информационное)
    private String consumerName;

    public Consumer(Producer producer, String consumerName) {
        this.producer = producer;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        producer.callAsynchronous(consumerName);
        producer.callSynchronous(consumerName);
    }
}
