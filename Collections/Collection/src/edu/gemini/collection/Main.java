package edu.gemini.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Демонстрация работы с коллекциями
 *
 */

/**
 * Описание коллекции
public interface Collection<E> extends Iterable<E> {
    // Basic operations
    int size();
    boolean isEmpty();
    boolean contains(Object element);
    boolean add(E element);         //optional
    boolean remove(Object element); //optional
    Iterator<E> iterator();

    // Bulk operations
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c); //optional
    boolean removeAll(Collection<?> c);        //optional
    boolean retainAll(Collection<?> c);        //optional
    void clear();                              //optional

    // Array operations
    Object[] toArray();
    <T> T[] toArray(T[] a);
}
*/
public class Main {

    public static void main(String[] args) {
        Collection col1 = createFirstCollection();
        Collection col2 = createSecondCollection();

        // Демонстрация прохода по коллекции
        System.out.println("Проход по коллекции");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();

        // Демонстрация прохода по коллекции через итератор
        System.out.println("Проход по коллекции через итератор");
        for (Iterator it = col1.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println("Item:" + o);
        }
        System.out.println();

        // Демонстрации групповых операций
        System.out.println("Групповые операции");
        // Можно проверить сожержаться ли ВСЕ элементы col2 в col
        if(col1.containsAll(col2)) {
            System.out.println("Коллекция col содержит все от col2");
        }
        System.out.println("Добавление всех элементов");
        col1.addAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("Удаление всех элементов");
        col1.removeAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("Удаление не содержащихся элементов");
        col1 = createFirstCollection();
        col2 = createSecondCollection();
        col1.retainAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("Очистка коллекции");
        col1.clear();
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();


        // Удаление коллекции через итератор
        System.out.println("Удаление через итератор");
        col1 = createFirstCollection();
        while(!col1.isEmpty()) {
            Iterator it = col1.iterator();
            if(it.hasNext()) {
                Object o = it.next();
                System.out.println("Удаляем:" + o);
                it.remove();
            }
        }
    }

    private static Collection createFirstCollection() {
        // Создать коллекцию
        Collection col = new Vector();
        // Добавление в коллекцию
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("6");
        col.add("7");
        return col;
    }

    private static Collection createSecondCollection() {
        // Вторая коллекция для примера
        Collection col2 = new Vector();
        col2.add("1");
        col2.add("2");
        col2.add("3");
        return col2;
    }
}
