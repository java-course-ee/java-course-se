package edu.javacourse.interfaces.impl;

import edu.javacourse.interfaces.iface.Doctor;
import edu.javacourse.interfaces.iface.Driver;

public class Human1 implements Driver, Doctor {
    @Override
    public void treat(String name) {
        System.out.println("Im' Human1, and I am treating " + name);
    }

    @Override
    public void drive(int speed) {
        System.out.println("Im' Human1, and I am driving " + speed);
    }
}
