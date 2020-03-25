package edu.javacourse.interfaces.impl;

import edu.javacourse.interfaces.iface.Doctor;

public class Human3 implements Doctor {
    @Override
    public void treat(String name) {
        System.out.println("Im' Human3, and I am treating " + name);
    }
}
