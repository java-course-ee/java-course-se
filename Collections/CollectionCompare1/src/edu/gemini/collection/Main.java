package edu.gemini.collection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Класс для демонстрации компараторов
 */
public class Main {

    public static void main(String[] args) {
        // Создаем объект класса SortedSet - стандартный класс для сортируемой коллекции
        // В качесве элементов - строки
        SortedSet<String> tr = new TreeSet<String>();

        // Добавляем стандартные типы - строки
        tr.add("Павел");
        tr.add("Петр");
        tr.add("Андрей");

        // И печатаем их
        for(String s: tr) {
            System.out.println(s);
        }

        // Создаем объект класса SortedSet - стандартный класс для сортируемой коллекции
        // В качестве элементов - свой класс
        SortedSet<MyClass> mt = new TreeSet<MyClass>();
        // Добавляем НЕ стандартные типы
        mt.add(new MyClass("Павел"));
        mt.add(new MyClass("Петр"));
        mt.add(new MyClass("Андрей"));

        for(MyClass s: mt) {
            System.out.println(s);
        }

    }

}

