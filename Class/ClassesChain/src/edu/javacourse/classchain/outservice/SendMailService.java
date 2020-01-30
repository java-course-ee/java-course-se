package edu.javacourse.classchain.outservice;

public class SendMailService {

    public void sendMail(String from, String to, String text) {
        System.out.println("\t\t\tSending mail to " + to + " with text " + text);
    }

}
