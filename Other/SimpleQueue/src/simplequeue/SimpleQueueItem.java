package simplequeue;

public class SimpleQueueItem {

    private Message message = null;
    private SimpleQueueItem next = null;

    public SimpleQueueItem(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public SimpleQueueItem getNext() {
        return next;
    }

    public void setNext(SimpleQueueItem next) {
        this.next = next;
    }
}
