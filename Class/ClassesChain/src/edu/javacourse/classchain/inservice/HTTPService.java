package edu.javacourse.classchain.inservice;

import edu.javacourse.classchain.bl.InternalBusinessLogic;
import edu.javacourse.classchain.entity.HTTPRequest;
import edu.javacourse.classchain.entity.HTTPResponse;

public class HTTPService {

    private InternalBusinessLogic logic;

    public void setLogic(InternalBusinessLogic logic) {
        this.logic = logic;
    }

    public HTTPResponse processRequest(HTTPRequest request) {
        System.out.println("\tReceived HTTP message");
        String text = request.getBody();
        logic.sendNotificationToAllEmployees(text);
        return new HTTPResponse("Ok, got it");
    }

}
