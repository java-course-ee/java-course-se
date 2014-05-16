package edu.gemini.student;

import edu.gemini.student.person.Adult;
import edu.gemini.student.person.ServiceClient;
import edu.gemini.student.service.EducationService;
import edu.gemini.student.service.PassportService;
import edu.gemini.student.service.RegistryOfficeService;
import edu.gemini.student.service.RequestStorageService;
import edu.gemini.student.service.SocialProtectionService;

public class CheckRequest {

    public void checkRequests() {
        // Подготовить нужные объекты
        RequestStorageService rsService = new RequestStorageService();
        PassportService passService = new PassportService();
        RegistryOfficeService roService = new RegistryOfficeService();
        EducationService eduService = new EducationService();
        SocialProtectionService spService = new SocialProtectionService();

        ServiceClient sc = null;
        do {
            System.out.println();
            sc = rsService.getUncheckedClient();
            if (sc != null) {
                boolean accepted = false;

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
                    continue;
                }
                // Проверяем паспортные данные жены
                accepted = passService.checkPassport(wife);
                if (!accepted) {
                    rsService.updateClient(sc, accepted);
                    continue;
                }
                // Проверяем регистрацию брака
                accepted = roService.checkMarriage(husband, wife, sc.getMarriageNumber(),
                        sc.getMarriageDate(), sc.getMarriageOffice());
                if (!accepted) {
                    rsService.updateClient(sc, accepted);
                    continue;
                }
                // Проверяем данные о детях
                accepted = roService.checkChildren(husband, wife, sc.getChildren());
                if (!accepted) {
                    rsService.updateClient(sc, accepted);
                    continue;
                }

                // Проверяем данные, что муж и жена учаться в ВУЗе
                accepted = eduService.checkStudent(husband) && eduService.checkStudent(wife);
                if (!accepted) {
                    rsService.updateClient(sc, accepted);
                    continue;
                }
                rsService.updateClient(sc, accepted);
                spService.acceptClient(sc);
            }
        } while (sc != null);
    }

    public static void main(String[] args) {
        CheckRequest checkReq = new CheckRequest();

        checkReq.checkRequests();
    }
}
