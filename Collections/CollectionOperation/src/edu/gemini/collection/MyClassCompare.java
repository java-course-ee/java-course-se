package edu.gemini.collection;

/**
 * пример произвольного класса для помещения в
 * сортируемую коллекцию
 */
public class MyClassCompare implements Comparable {

    private String name;

    public MyClassCompare(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        if (o instanceof MyClassCompare) {
            MyClassCompare mc = (MyClassCompare) o;
            return name.compareTo(mc.name);
        }
        throw new ClassCastException();
    }

    @Override
    public String toString() {
        return name;
    }
}
