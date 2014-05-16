package edu.gemini.student.person;

import java.util.Date;
import java.util.List;

/**
 * Класс для данных о заявителе
 *
 * @author ASaburov
 */
public class ServiceClient extends Adult {

    // Данные о супруге
    private Adult spouse;
    // Данные о номере свидетельства о браке
    private String marriageNumber;
    // Данные о дате свидетельства о браке
    private Date marriageDate;
    // Данные о месте выдачи свидетельства о браке
    private String marriageOffice;
    // Данныео детях
    private List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getMarriageNumber() {
        return marriageNumber;
    }

    public void setMarriageNumber(String marriageNumber) {
        this.marriageNumber = marriageNumber;
    }

    public String getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(String marriageOffice) {
        this.marriageOffice = marriageOffice;
    }

    public Adult getSpouse() {
        return spouse;
    }

    public void setSpouse(Adult spouse) {
        this.spouse = spouse;
    }
}
