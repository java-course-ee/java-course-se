package edu.gemini.thread;

/**
 * Простой объект у которого есть сихронизованный метод
 * @author ASaburov
 */
public class SynchroObject {

//    public synchronized void synchroMethod(String message) throws InterruptedException {
    public void synchroMethod(String message) throws InterruptedException {
        System.out.println("Synchro before:" + message);
        Thread.sleep(3000);
        System.out.println("Synchro after:" + message);
    }

}
