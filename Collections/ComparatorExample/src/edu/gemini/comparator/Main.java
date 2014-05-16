package edu.gemini.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Пример "универсального" компаратора, который сравнивает
 * объекты по разным полям с учетом спецификации JavaBeans
 * @author ASaburov
 */
public class Main {

    public static void main(String[] args) {
        List<TestClass> list = new ArrayList<TestClass>();

        list.add(new TestClass("5", 1));
        list.add(new TestClass("3", 3));
        list.add(new TestClass("1", 5));
        list.add(new TestClass("4", 1));
        list.add(new TestClass("2", 3));

        for (TestClass tc : list) {
            System.out.println(tc);
        }

        System.out.println("Сортировка по полю NAME ===================");
        Collections.sort(list, new FieldComparator("name"));
        for (TestClass tc : list) {
            System.out.println(tc);
        }

        System.out.println("Сортировка по полю AGE ===================");
        Collections.sort(list, new FieldComparator("age"));
        for (TestClass tc : list) {
            System.out.println(tc);
        }
    }
}
