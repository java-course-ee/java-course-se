package edu.gemini.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard3 {

    class Vehicle {
    }

    class Bus extends Vehicle {
    }

    class Train extends Vehicle {
    }

    private void processElements(List<? extends Vehicle> elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }

    public static void main(String[] arg) {
        GenericWildcard3 cw3 = new GenericWildcard3();
        cw3.processElements(new ArrayList<Vehicle>());
        cw3.processElements(new ArrayList<Bus>());
        cw3.processElements(new ArrayList<Train>());
    }
}

