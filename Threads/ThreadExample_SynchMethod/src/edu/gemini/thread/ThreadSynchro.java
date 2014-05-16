package edu.gemini.thread;

public class ThreadSynchro extends Thread {

    private SynchroObject obj;

    public ThreadSynchro(String name, SynchroObject obj) {
        super(name);
        // Это объект для синхронизации
        this.obj = obj;
    }

    @Override
    public void run() {
        sayHello(getName());
    }

    // если добавить static, то синхронизация будет на уровне класса
    //public static synchronized void sayHello(String message) {
    public synchronized void sayHello(String message) {
        try {
            System.out.println("Hello before !!!" + message);
            Thread.sleep(3000);
            System.out.println("Hello after !!!" + message);

            // Либо метод должен быть synchronized
            obj.synchroMethod(message);
            // либо синхронизация специальным вызовом на уровне объекта
//            synchronized(obj) {
//                obj.synchroMethod(message);
//            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
