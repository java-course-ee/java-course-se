package edu.gemini.collection;

import java.util.Comparator;

/**
 *
 * @author ASaburov
 */
public class MyClassComparator implements Comparator {

    public MyClassComparator() {
    }

    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }

}
