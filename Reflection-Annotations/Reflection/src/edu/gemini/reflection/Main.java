package edu.gemini.reflection;

import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Пример работы с классами через механизм Reflection
 *
 * @author ASaburov
 */
public class Main {

    /**
     * Создание объекта через reflection
     */
    static Object createObject(String className) {
        Object object = null;
        try {
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return object;
    }

    /**
     * Обращение к полю объекта через reflection
     */
    static void printHeight(Rectangle r) {
        Field heightField;
        Integer heightValue;
        Class c = r.getClass();
        try {
            heightField = c.getField("height");
            heightValue = (Integer) heightField.get(r);
            System.out.println("Height: " + heightValue.toString());
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        } catch (SecurityException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Изменение поля объекта через reflection
     */
    static void modifyWidth(Rectangle r, Integer widthParam) {
        Field widthField;
        Class c = r.getClass();
        try {
            widthField = c.getField("width");
            widthField.set(r, widthParam);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Пример вызова метода для объекта с аргументами
     */
    public static String append(String firstWord, String secondWord) {
        // Поле для хранения результата
        String result = null;
        // Описание классов для параметров
        Class[] parameterTypes = new Class[]{String.class};
        // Создание значений параметров
        Object[] arguments = new Object[]{secondWord};
        // Специальный класс для указания на метод
        Method concatMethod;
        try {
            // Вызов метода "concat" для строки - см. описание String
            concatMethod = String.class.getMethod("concat", parameterTypes);
            result = (String) concatMethod.invoke(firstWord, arguments);
        } catch (NoSuchMethodException ex) {
            System.out.println(ex);
        } catch (SecurityException ex) {
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        } catch (InvocationTargetException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static void main(String[] args) {
            // Создание объекта
            Rectangle r = (Rectangle) createObject("java.awt.Rectangle");
            System.out.println(r.toString());

            // Доступ к полю
            printHeight(r);

            // Модификация поля
            System.out.println("Not modified: " + r.toString());
            modifyWidth(r, new Integer(300));
            System.out.println("Modified: " + r.toString());

            // Вызов метода
            String firstWord = "Hello ";
            String secondWord = "everybody.";
            String bothWords = append(firstWord, secondWord);
            System.out.println(bothWords);
            
        try {
            // Пример обращение к private полю
            ReflectClass rc = new ReflectClass("Simple value");
            System.out.println(r.toString());
            
            Field privateStringField = ReflectClass.class.getDeclaredField("value");
            privateStringField.setAccessible(true);
            String fieldValue = (String) privateStringField.get(rc);
            System.out.println("fieldValue = " + fieldValue);
            //privateStringField.set(r, "New simple value");
            //System.out.println("fieldValue = " + fieldValue);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }
}
