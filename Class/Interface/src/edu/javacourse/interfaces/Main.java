package edu.javacourse.interfaces;

import edu.javacourse.interfaces.impl.Human1;
import edu.javacourse.interfaces.impl.Human2;
import edu.javacourse.interfaces.impl.Human3;
import edu.javacourse.interfaces.service.Autobase;
import edu.javacourse.interfaces.service.Hospital;

public class Main {
    public static void main(String[] args) {

        final Hospital hospital = new Hospital();
        final Autobase autobase = new Autobase();

        Human1 ivan = new Human1();
        hospital.hire(ivan);
        autobase.hire(ivan);

        Human2 petr = new Human2();
//        hospital.hire(petr); // Cannot invoke
        autobase.hire(petr);

        Human3 sidor = new Human3();
        hospital.hire(sidor);
//        autobase.hire(sidor); // Cannot invoke
    }
}
