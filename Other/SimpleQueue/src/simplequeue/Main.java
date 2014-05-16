package simplequeue;

public class Main {

    public static void main(String[] args) {
        SimpleQueue sq = new SimpleQueue();

        for (int i = 0; i < 10; i++) {
            Message m = new Message("sender_" + i, "receiver_" + i, "text_" + i);
            sq.put(m);
            System.out.println("Message:" + m);
        }

        System.out.println("Size:" + sq.size());
        sq.printQueue();

        while (sq.size() > 5) {
            Message m = sq.get();
            System.out.println("Message:" + m);
        }
        System.out.println("Size after getting:" + sq.size());
        sq.printQueue();
        System.out.println("Size after getting:" + sq.size());
    }
}
