package edu.gemini.student;

import edu.gemini.student.person.Adult;
import edu.gemini.student.person.ServiceClient;
import edu.gemini.student.service.EducationService;
import edu.gemini.student.service.PassportService;
import edu.gemini.student.service.RegistryOfficeService;
import edu.gemini.student.service.RequestStorageService;
import edu.gemini.student.service.SocialProtectionService;

public class ClientThread extends Thread {

    private ServiceClient sc;
    private RequestStorageService rsService;

    public ClientThread(ServiceClient sc, RequestStorageService rsService) {
        this.sc = sc;
        this.rsService = rsService;
    }

    @Override
    public void run() {
        System.out.println("Client process is started:" + sc.getFirstName());

        PassportService passService = new PassportService();
        RegistryOfficeService roService = new RegistryOfficeService();
        EducationService eduService = new EducationService();
        SocialProtectionService spService = new SocialProtectionService();

        boolean accepted = false;

        try {
            Thread.sleep(Math.round(Math.random()*2000.0));
        } catch(Exception e) {
        }

        // Выбираем, кто муж а кто жена
        Adult husband = null;
        Adult wife = null;
        if (sc.isMale()) {
            husband = sc;
            wife = sc.getSpouse();
        } else {
            wife = sc;
            husband = sc.getSpouse();
        }


        // Проверяем паспортные данные мужа
        accepted = passService.checkPassport(husband);
        if (!accepted) {
            rsService.updateClient(sc, accepted);
            return;
        }
        // Проверяем паспортные данные жены
        accepted = passService.checkPassport(wife);
        if (!accepted) {
            rsService.updateClient(sc, accepted);
            return;
        }
        // Проверяем регистрацию брака
        accepted = roService.checkMarriage(husband, wife, sc.getMarriageNumber(),
                sc.getMarriageDate(), sc.getMarriageOffice());
        if (!accepted) {
            rsService.updateClient(sc, accepted);
            return;
        }
        // Проверяем данные о детях
        accepted = roService.checkChildren(husband, wife, sc.getChildren());
        if (!accepted) {
            rsService.updateClient(sc, accepted);
            return;
        }

        // Проверяем данные, что муж и жена учаться в ВУЗе
        accepted = eduService.checkStudent(husband) && eduService.checkStudent(wife);
        if (!accepted) {
            rsService.updateClient(sc, accepted);
            return;
        }
        rsService.updateClient(sc, accepted);
        spService.acceptClient(sc);
    }
}
