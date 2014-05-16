package edu.gemini.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Пример для List
 */
/*
public interface List<E> extends Collection<E> {
    // Positional access
    E get(int index);
    E set(int index, E element);    //optional
    boolean add(E element);         //optional
    void add(int index, E element); //optional
    E remove(int index);            //optional
    boolean addAll(int index,
        Collection<? extends E> c); //optional

    // Search
    int indexOf(Object o);
    int lastIndexOf(Object o);

    // Iteration
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);

    // Range-view
    List<E> subList(int from, int to);
}
*/
public class Main {

    public static void main(String[] args) {
        List list = createFirstList();

        // Добавление в List более интересное - можно на любую позицию
        list.add(0, "0");

        // Получение элемнта по индексу
        System.out.println("Получить по индексу");
        for(int i=0; i<list.size(); i++) {
            Object o = list.get(i);
            System.out.println("Item:" + o);
        }
        System.out.println();


        // Передвижение по списку
        System.out.println("Прямое прохождение");
        for(ListIterator li = list.listIterator(); li.hasNext();) {
            System.out.println("Index:" + li.nextIndex());
            Object o = li.next();
            System.out.println("Item:" + o + " Index:" + li.nextIndex());
        }
        System.out.println();
        
        // Обратное передвижение по списку
        System.out.println("Обратное прохождение");
        for(ListIterator li = list.listIterator(list.size()); li.hasPrevious();) {
            System.out.println("Index:" + li.previousIndex());
            Object o = li.previous();
            System.out.println("Item:" + o + " Index:" + li.previousIndex());
        }
        System.out.println();

        // Выделение подсписка
        System.out.println("Выделение подсписка");
        List subList = list.subList(2, list.size());
        for(Object o : subList) {
            System.out.println("Item:" + o);
        }
        // Удаление подсписка
        System.out.println("Удаление подсписка");
        list.subList(2, list.size()).clear();
        for(Object o : list) {
            System.out.println("Item:" + o);
        }
    }

    private static List createFirstList() {
        List l = new ArrayList();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        return l;
    }

}
