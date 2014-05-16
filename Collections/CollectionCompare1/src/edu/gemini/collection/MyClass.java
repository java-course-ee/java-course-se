package edu.gemini.collection;

/**
 * пример произвольного класса для помещения в
 * сортируемую коллекцию
 */
public class MyClass {

    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
