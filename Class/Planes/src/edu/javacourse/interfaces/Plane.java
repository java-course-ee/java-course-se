package edu.javacourse.interfaces;

public class Plane implements Flyable, Cargoable {

    private Cargo cargo;

    @Override
    public void fly(String dest) {
        System.out.println("Plane fly to " + dest + " with cargo '" + cargo.getData() + "'");
    }

    @Override
    public void put(Cargo cargo) {
        this.cargo = cargo;
        System.out.println("Cargo '" + cargo.getData() + "' put in the plane");
    }
}
