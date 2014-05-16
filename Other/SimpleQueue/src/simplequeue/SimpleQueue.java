package simplequeue;

public class SimpleQueue {

    private SimpleQueueItem first = null;
    private SimpleQueueItem last = null;
    private int count = 0;

    public void put(Message m) {
        SimpleQueueItem sqi = new SimpleQueueItem(m);
        if (count == 0) {
            first = sqi;
        }
        if (last != null) {
            last.setNext(sqi);
        }
        last = sqi;
        count++;
    }

    public Message get() {
        if (count == 0) {
            return null;
        }
        Message m = first.getMessage();
        if (count == 1) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
        }
        count--;
        return m;
    }

    public int size() {
        return count;
    }

    public void printQueue() {
        if(first!=null) {
            System.out.println(first.getMessage());
            SimpleQueueItem current = first;
            while(current.getNext()!=null) {
                System.out.println(current.getNext().getMessage());
                current = current.getNext();
            }
        }
    }

    public void clearAll() {
        count = 0;
        first = null;
        last = null;
    }
}
