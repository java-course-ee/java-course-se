package edu.gemini.thread;

public class Producer extends Thread {

    private Manager manager;

    public Producer(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for (int i = 0; i < Manager.COUNT; i++) {
            manager.put(i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}

