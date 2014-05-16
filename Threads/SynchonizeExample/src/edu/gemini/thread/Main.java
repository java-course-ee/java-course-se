package edu.gemini.thread;

public class Main {

    private static final int NUMBER = 10;

    public static void main(String[] args) {
        Producer pr = new Producer();

        Consumer[] c = new Consumer[NUMBER];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Consumer(pr, "Consumer_" + i);
            c[i].start();
        }

    }
}
