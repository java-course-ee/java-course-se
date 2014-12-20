package edu.javacourse.threads;

import java.util.Random;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Pong implements Runnable {

    private static final Random RANDOM = new Random();

    private Judge judge;

    public Pong(Judge judge) {
        this.judge = judge;
    }

    @Override
    public void run() {
        synchronized (judge) {
            while (true) {
                if (judge.getTurn() == 1) {
                    System.out.println("Pong");
                    judge.setTurn(0);
                    try {
                        Thread.sleep(RANDOM.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    judge.notifyAll();
                } else {
                    try {
                        judge.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
