package edu.gemini.thread;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        SimpleThread st = new SimpleThread();
        st.start();
		System.out.println("1");
        st.join();
		System.out.println("2");
    }
}
