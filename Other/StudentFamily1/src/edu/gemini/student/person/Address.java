package edu.gemini.student.person;

/**
 * Клас для хранения данных адреса
 *
 * @author ASaburov
 */
public class Address {

    private String street;
    private String house;
    private String flat;

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
