package edu.gemini.collection;

/**
 * пример произвольного класса для помещения в
 * сортируемую коллекцию
 */
public class MyClass implements Comparable {

    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        if(o instanceof MyClass) {
            MyClass mc = (MyClass) o;
            return name.compareTo(mc.name);
        }
        throw new ClassCastException();
    }

    @Override
    public String toString() {
        return name;
    }

}
