package edu.gemini.student.person;

import java.util.Date;

/**
 * Класс для данных о ребенке
 *
 * @author ASaburov
 */
public class Child extends Person {

    // Серия свидетельства о рождении
    private String birthSeries;
    // Номер свидетельства о рождении
    private String birthNumber;
    // Дата свидетельства о рождении
    private Date birthDate;
    // Место выдачи свидетельства о рождении
    private String birthOffice;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    public String getBirthOffice() {
        return birthOffice;
    }

    public void setBirthOffice(String birthOffice) {
        this.birthOffice = birthOffice;
    }

    public String getBirthSeries() {
        return birthSeries;
    }

    public void setBirthSeries(String birthSeries) {
        this.birthSeries = birthSeries;
    }
}
