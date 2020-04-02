package edu.javacourse.interfaces;

public class Main {
    public static void main(String[] args) {
        ControlCenter controlCenter = new ControlCenter();

        Cargo secretCargo = new Cargo();
        secretCargo.setData("Secret key to launch missile");

        Plane airbus319 = new Plane();

        controlCenter.putCargo(secretCargo, airbus319); // Using airbus319 as Cargoable
        controlCenter.deliver(secretCargo, airbus319, "New York"); // Using airbus319 as Flyable

        System.out.println();
        System.out.println("******************************************************");
        System.out.println();

        Cargo mailCargo = new Cargo();
        mailCargo.setData("Dear Santa...");

        Helicopter bell206 = new Helicopter();

        controlCenter.putCargo(mailCargo, bell206); // Using bell206 as Cargoable
        controlCenter.deliver(mailCargo, bell206, "North Pole"); // Using bell206 as Flyable
    }
}
