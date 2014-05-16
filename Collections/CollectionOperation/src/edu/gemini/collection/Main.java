package edu.gemini.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Демонстрация различных операций над списком
 */
public class Main {

    public static void main(String[] args) {

        List<MyClass> list = new ArrayList<MyClass>();

        list.add(new MyClass("Василий"));
        list.add(new MyClass("Павел"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Петр"));
        list.add(new MyClass("Анжелика"));

        System.out.println("Оригинал");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Смешивание
        Collections.shuffle(list);
        System.out.println("Смешивание");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Обратный порядок
        Collections.reverse(list);
        System.out.println("Обратный порядок");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // "Проворачивание" на определенное количество
        Collections.rotate(list, 2); // Число может быть отрицательным - тогда порядок будет обратный
        System.out.println("Проворачивание");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Обмен элементов
        Collections.swap(list, 0, list.size()-1);
        System.out.println("Обмен элементов");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Замена
        Collections.replaceAll(list, new MyClass("Андрей"), new MyClass("Алексей"));
        System.out.println("Замена");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Сортировка
        //Collections.sort(list);   // Этот запрос не пройдет т.к. класс MyClass
                                    // не реализует интерфейс Comparable
        System.out.println("Сортировка Comparable класса");
        List<MyClassCompare> listSort = new ArrayList<MyClassCompare>();
        System.out.println("Без сортировки");
        for(MyClass mc : list) {
            listSort.add(new MyClassCompare(mc.toString()));
            System.out.println("Item sort:" + mc);
        }
        Collections.sort(listSort);
        System.out.println("После сортировки");
        for(MyClassCompare mc : listSort) {
            System.out.println("Item sort:" + mc);
        }
        System.out.println();

        // Сортировка с классом Comparator
        System.out.println("Сортировка с Comparator");
        System.out.println("Без сортировки");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        Collections.sort(list, new MyClassComparator());
        System.out.println("После сортировки");
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();


        // Копирование - здесь обязательно надо иметь нужные размеры
        List<MyClass> list2 = new ArrayList<MyClass>();
        // Поэтому заполняем список. Хоть чем-нибудь.
        for(MyClass mc : list) {
            list2.add(null);
        }
        // Компируем из правого аргумента в левый
        Collections.copy(list2, list);
        System.out.println("Копирование");
        for(MyClass mc : list2) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

        // Полная замена
        Collections.fill(list2, new MyClass("Антон"));
        System.out.println("Полная замена");
        for(MyClass mc : list2) {
            System.out.println("Item:" + mc);
        }
        System.out.println();

    }

}
