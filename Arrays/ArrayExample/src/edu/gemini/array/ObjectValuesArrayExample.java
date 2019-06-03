package edu.gemini.array;

/**
 * Пример для ознакомления с массивом
 * 
 */
public class ObjectValuesArrayExample {

    public static void main(String[] args) {

        String[] strArray;

        strArray = new String[4];

        strArray[0] = "Zero";
        strArray[1] = "One";
        strArray[2] = "Two";

        // Заметьте, что значение последнего элемента массива - null. Мы его не определили.
        for (int i = 0; i < strArray.length; i++) {
            System.out.println("Array element with index " + i + " value is " + strArray[i]);
        }


        // Следующая конструкция выдаст ошибку, т.к. мы пытаемся обратиться к несуществующему элементу массива
//        System.out.println(strArray[10]);

    }
}
