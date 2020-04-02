package edu.javacourse.interfaces;

public class ControlCenter {

    public void deliver(Cargo cargo, Flyable flyable, String destination) {
        flyable.fly(destination);
    }

    public void putCargo(Cargo cargo, Cargoable cargoable) {
        cargoable.put(cargo);
    }

}
