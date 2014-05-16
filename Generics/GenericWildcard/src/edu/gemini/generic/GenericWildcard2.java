package edu.gemini.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard2 {

    class Vehicle {
    }

    class Bus extends Vehicle {
    }

    class Train extends Vehicle {
    }

    private void processElements(List<?> elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }

    public static void main(String[] arg) {
        GenericWildcard2 cw2 = new GenericWildcard2();
        cw2.processElements(new ArrayList<Object>());

        cw2.processElements(new ArrayList<Vehicle>());
        cw2.processElements(new ArrayList<Bus>());
        cw2.processElements(new ArrayList<Train>());
    }
}

