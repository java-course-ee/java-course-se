package edu.gemini.array;

/**
 * Пример для ознакомления с массивом
 * 
 */
public class ArrayExample {

    public static void main(String[] args) {

        // Пример записи одномерного массива
        int[] array1 = new int[5];
        System.out.println(array1.getClass().getSimpleName());

        // Убеждаемся, что наследование произошло от класса Object
        System.out.println("Parent:" + array1.getClass().getSuperclass().getSimpleName());
        System.out.println();
        // Присваивание элементам массива данных
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i * 11;
        }

        // Печать элементов массива
        for (int i = 0; i < array1.length; i++) {
            System.out.println("A[" + i + "]=" + array1[i]);
        }
    }
}
