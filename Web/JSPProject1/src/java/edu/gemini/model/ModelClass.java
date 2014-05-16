package edu.gemini.model;

/**
 * Класс для хранения данных, которые будут использованы на JSP
 */
public class ModelClass {

    private String firstName;
    private String lastName;

    public ModelClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
