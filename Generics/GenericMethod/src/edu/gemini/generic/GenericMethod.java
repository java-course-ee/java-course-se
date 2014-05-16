package edu.gemini.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod {

    public <T> T addAndReturn(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }

    public static void main(String[] arg) {
        GenericMethod gm = new GenericMethod();
        String stringElement = "stringElement";
        List<String> stringList = new ArrayList<String>();
        String theElement1 = gm.addAndReturn(stringElement, stringList);
        System.out.println("Element1:" + theElement1);
        System.out.println("Element1:" + theElement1.getClass().getSimpleName());

        Integer integerElement = new Integer(123);
        List<Integer> integerList = new ArrayList<Integer>();
        Integer theElement2 = gm.addAndReturn(integerElement, integerList);
        System.out.println("Element2:" + theElement2);
        System.out.println("Element2:" + theElement2.getClass().getSimpleName());
    }
}
