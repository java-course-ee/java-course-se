package edu.javacourse.threads;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class PingPong {

    public static void main(String[] args) throws InterruptedException {
        Judge judge = new Judge();

        Thread ping = new Thread(new Ping(judge));
        Thread pong = new Thread(new Pong(judge));

        System.out.println("Starting Pong");
        pong.start();

        Thread.sleep(4000);

        System.out.println("Starting Ping");
        ping.start();

    }

}
