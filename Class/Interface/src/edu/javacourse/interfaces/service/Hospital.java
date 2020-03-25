package edu.javacourse.interfaces.service;

import edu.javacourse.interfaces.iface.Doctor;

public class Hospital {

    public void hire(Doctor doc) {
        doc.treat("Jane Doe");
    }

}
