package edu.gemini.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard1 {

    class Vehicle {
    }

    class Bus extends Vehicle {
    }

    class Train extends Vehicle {
    }

    private void processElements(List<Object> elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }

    public static void main(String[] arg) {
        GenericWildcard1 cw1 = new GenericWildcard1();
        cw1.processElements(new ArrayList<Object>());

        // Строки не не будут компилироваться
        //cw1.processElements(new ArrayList<Vehicle>());
        //cw1.processElements(new ArrayList<Bus>());
        //cw3.processElements(new ArrayList<Train>());
    }
}

