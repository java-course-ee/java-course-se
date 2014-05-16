package edu.gemini.thread;

public class JoinedThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Joined Thread 1");
            Thread.sleep(3000);
            System.out.println("Joined Thread 2");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
