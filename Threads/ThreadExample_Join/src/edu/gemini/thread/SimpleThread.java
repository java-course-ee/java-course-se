package edu.gemini.thread;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Simple Thread 1");
            JoinedThread jt = new JoinedThread();
            jt.start();
            // Если закомментировать строку с join, то поток SimpleThread
            // закончится раньше, чем JoinedThread
//            jt.join();
            System.out.println("Simple Thread 2");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
