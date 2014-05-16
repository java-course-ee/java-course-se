package edu.gemini.array;

/**
 * Пример многомерных массивов
 */
public class ArrayMultiExample {

    public static void main(String[] args) {
        // Пример записи двумерного массива
        int[][] array2 = new int[3][4];
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        /*
        // Пример двумерного массива без определения вложенных массивов
        int[][] array3 = new int[6][];
        System.out.println();
        for (int i = 0; i < array3.length; i++) {
            // Здесь возникнет исключение - обращение к неинициализированной ссылке
            for (int j = 0; j < array3[i].length; j++) {
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        */
    }
}
