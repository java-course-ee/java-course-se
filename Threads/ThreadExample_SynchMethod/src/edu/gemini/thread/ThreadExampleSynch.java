package edu.gemini.thread;

public class ThreadExampleSynch {

    public static void main(String[] args) {
        SynchroObject obj = new SynchroObject();
        
        ThreadSynchro ts1 = new ThreadSynchro("First", obj);
        ts1.start();
        ThreadSynchro ts2 = new ThreadSynchro("Second", obj);
        ts2.start();
    }
    
}
