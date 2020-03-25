package edu.javacourse.interfaces.impl;

import edu.javacourse.interfaces.iface.Driver;

public class Human2 implements Driver {
    @Override
    public void drive(int speed) {
        System.out.println("Im' Human2, and I am driving");
    }
}
