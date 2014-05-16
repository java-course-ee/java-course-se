package edu.gemini.comparator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * Пример "универсального" компаратора, который сравнивает
 * объекты по разным полям с учетом спецификации JavaBeans
 * @author ASaburov
 */
public class FieldComparator implements Comparator {

    private String fieldName;

    public FieldComparator(String fieldName) {
        this.fieldName = fieldName;
    }

    public int compare(Object o1, Object o2) {
        // Специальный класс для указания на метод
        Method concatMethod;

        try {
            String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            concatMethod = o1.getClass().getMethod(methodName);
            Comparable result1 = (Comparable) concatMethod.invoke(o1);
            Comparable result2 = (Comparable) concatMethod.invoke(o2);
            return result1.compareTo(result2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /*
    public int compare(Object o1, Object o2) {
    Field field1;
    Field field2;
    Class c1 = o1.getClass();
    Class c2 = o2.getClass();
    try {
    field1 = c1.getField(fieldName);
    Comparable value1 = (Comparable) field1.get(o1);
    field2 = c2.getField(fieldName);
    Comparable value2 = (Comparable) field2.get(o2);
    return value1.compareTo(value2);
    } catch (Exception e) {
    throw new RuntimeException(e.getMessage());
    }
    }
     */
}
