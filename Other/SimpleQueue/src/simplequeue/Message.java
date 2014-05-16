package simplequeue;

public class Message {

    String sender;
    String receiver;
    String text;

    public Message(String sender, String receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Sender:" + sender + ", Receiver:" + receiver + ", Text:" + text;
    }
}
