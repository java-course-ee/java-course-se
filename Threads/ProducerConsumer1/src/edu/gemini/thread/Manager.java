package edu.gemini.thread;

/**
 *
 * @author ASaburov
 */
public class Manager {

    public static final int COUNT = 10;
    //
    private int contents;

    // Метод отдает последнее число, переданное от Producer
    // Вызывается из Consumer
    public synchronized int get() {
        System.out.println("GET");
        System.out.println("Consumer got: " + contents);
        return contents;
    }

    // Метод сохраняет последнее число, переданное от Producer
    // Вызывается из Producer
    // Ключевое слово "synchronized" говорит о том, что пока мы находимся
    // внутри этого метода, метод блокируется для использования другими потоками
    public synchronized void put(int value) {
        System.out.println("PUT");
        System.out.println("Producer put: " + value);
        contents = value;
    }
}

