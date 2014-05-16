package edu.gemini.student.person;

import java.util.Date;

/**
 * Класс для данных о взрослом
 *
 * @author ASaburov
 */
public class Adult extends Person {

    private String passSeries;
    private String passNumber;
    private Date passDate;
    private String passOffice;

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public String getPassOffice() {
        return passOffice;
    }

    public void setPassOffice(String passOffice) {
        this.passOffice = passOffice;
    }

    public String getPassSeries() {
        return passSeries;
    }

    public void setPassSeries(String passSeries) {
        this.passSeries = passSeries;
    }
}
