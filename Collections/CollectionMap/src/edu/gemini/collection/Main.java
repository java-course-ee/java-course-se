package edu.gemini.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * пример Map
 */
/*
public interface Map<K,V> {

// Basic operations
V put(K key, V value);
V get(Object key);
V remove(Object key);
boolean containsKey(Object key);
boolean containsValue(Object value);
int size();
boolean isEmpty();

// Bulk operations
void putAll(Map<? extends K, ? extends V> m);
void clear();

// Collection Views
public Set<K> keySet();
public Collection<V> values();
public Set<Map.Entry<K,V>> entrySet();

// Interface for entrySet elements
public interface Entry {
K getKey();
V getValue();
V setValue(V value);
}
}
 */
public class Main {

    public static void main(String[] args) {
        Map map = new HashMap();

        // Добавление
        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");

        // Получение
        System.out.println("Second:" + map.get(2));

        // Удаление
        map.remove(3);
        
        // Проверка наличия ключа
        if(map.containsKey(1)) {
            System.out.println("Key is contained");
        }
        // Проверка наличия значения
        if(map.containsValue("First")) {
            System.out.println("1 Value is contained");
        }
        if(map.containsValue("Third")) {
            System.out.println("2 Value is contained");
        }

        // Проход по коллекциям элементов
        System.out.println("По ключам");
        for(Object o : map.keySet()) {
            System.out.println("Key:" + o);
        }
        System.out.println("По значениям");
        for(Object o : map.values()) {
            System.out.println("Value:" + o);
        }
        System.out.println("По парам");
        for(Object o : map.entrySet()) {
            Map.Entry me = (Map.Entry) o;
            System.out.println("Key:" + me.getKey() + " Value:" + me.getValue());
        }
    }
}
