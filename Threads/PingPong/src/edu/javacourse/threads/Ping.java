package edu.javacourse.threads;

import java.util.Random;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Ping implements Runnable {

    private static final Random RANDOM = new Random();

    private Judge judge;

    public Ping(Judge judge) {
        this.judge = judge;
    }

    @Override
    public void run() {
        synchronized (judge) {
            while (true) {
                if (Turn.PING.equals(judge.getTurn())) {
                    System.out.println(Turn.PING);
                    judge.setTurn(Turn.PONG);
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
