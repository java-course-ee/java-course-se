package edu.gemini.thread;

/**
 *
 * @author ASaburov
 */
public class Main {

    public static void main(String[] args) {
        Manager c = new Manager();
        Producer p1 = new Producer(c);
        Consumer c1 = new Consumer(c);

        // Стартуем производителя величин
        p1.start();

        // Если мы сделаем перерыв между стартами, то точно не сможем писать и читать синхронно
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
        }

        // Стартуем потребителя величин
        c1.start();
    }
}
