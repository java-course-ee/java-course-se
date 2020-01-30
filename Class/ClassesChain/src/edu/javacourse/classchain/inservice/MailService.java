package edu.javacourse.classchain.inservice;

import edu.javacourse.classchain.bl.InternalBusinessLogic;
import edu.javacourse.classchain.entity.MailMessage;

public class MailService {

    private InternalBusinessLogic logic;

    public void setLogic(InternalBusinessLogic logic) {
        this.logic = logic;
    }

    public void receiveMessage(MailMessage message) {
        System.out.println("\tReceived mail message");
        logic.addSalaryToAllEmployees(1000);
    }

}
