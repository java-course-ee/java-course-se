package edu.javacourse.classchain;

import edu.javacourse.classchain.bl.InternalBusinessLogic;
import edu.javacourse.classchain.dao.DBAccess;
import edu.javacourse.classchain.entity.HTTPRequest;
import edu.javacourse.classchain.entity.HTTPResponse;
import edu.javacourse.classchain.entity.MailMessage;
import edu.javacourse.classchain.inservice.HTTPService;
import edu.javacourse.classchain.inservice.MailService;
import edu.javacourse.classchain.outservice.SendMailService;

public class Main {
    public static void main(String[] args) {

        DBAccess dbAccess = new DBAccess();
        SendMailService sendMailService = new SendMailService();

        InternalBusinessLogic internalBusinessLogic = new InternalBusinessLogic();
        internalBusinessLogic.setDb(dbAccess);
        internalBusinessLogic.setMailService(sendMailService);

        HTTPService httpService = new HTTPService();
        httpService.setLogic(internalBusinessLogic);

        MailService mailService = new MailService();
        mailService.setLogic(internalBusinessLogic);

        System.out.println("Sending mail message...");
        MailMessage message = new MailMessage();
        mailService.receiveMessage(message);
        System.out.println("Mail message processed");

        System.out.println("Sending HTTP message");
        HTTPRequest request = new HTTPRequest();
        request.setBody("Hello World to everyone");
        HTTPResponse httpResponse = httpService.processRequest(request);
        String responseBody = httpResponse.getBody();
        System.out.println("Http Service responded: " + responseBody);
        System.out.println("HTTP message processed");
    }
}
