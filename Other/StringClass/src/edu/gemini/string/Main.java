package edu.gemini.string;

import java.util.Date;

/**
 *
 * @author ASaburov
 */
public class Main {

    private void demoString() {
        String test = "test string for all examples";
        String other = "test string for all examples";
        String testUp = "TEST STRING FOR ALL EXAMPLES";

        // Получение символа на определенной позиции
        System.out.println("====> Получение символа:");
        System.out.println(test.charAt(0));
        System.out.println(test.charAt(1));
        System.out.println(test.charAt(2));
        System.out.println(test.charAt(3));

        // Сравнение строк
        System.out.println("====> Сравнение:");
        System.out.println("Compare:" + test.compareTo(other));

        // Сравнение с регистром
        System.out.println("====> Сравнение с регистром:");
        System.out.println("Compare:" + testUp.compareTo(test));
        System.out.println("Compare:" + testUp.compareToIgnoreCase(test));

        // Преобразование регистра
        System.out.println("====> Работа с регистром:");
        System.out.println("String:" + test.toLowerCase());
        System.out.println("UPPER:" + test.toUpperCase());
        System.out.println("String:" + testUp);
        System.out.println("lower:" + testUp.toLowerCase());

        // Разделение строк
        System.out.println("====> Разделение:");
        String[] sList = test.split("\\s");
        for (String s : sList) {
            System.out.println(s);
        }

        // Подстроки, замены
        System.out.println("====> Подстроки, замены:");
        System.out.println("Замена:" + test.replaceAll("t", "T"));
        System.out.println("Подстрока:" + test.substring(2, 15));

        // Начало, окончание
        System.out.println("====> Начало, окончание:");
        if (test.startsWith("test str")) {
            System.out.println("Строка начинается с \"test str\"");
        }
        if (test.endsWith("all examples")) {
            System.out.println("Строка оканчивается на \"all examples\"");
        }
    }

    private void demoStringBuffer() {
        int count = 40000;

        String d = new String("");
        System.out.println();
        System.out.println("Демонстрация изменения String");
        System.out.println(new Date());
        for (int i = 0; i < count; i++) {
            d += "1";
        }
        System.out.println(new Date());

        StringBuffer sb1 = new StringBuffer();
        System.out.println();
        System.out.println("Демонстрация изменения StringBuffer");
        System.out.println(new Date());
        for (int i = 0; i < count; i++) {
            sb1.append("1");
        }
        System.out.println(new Date());

        StringBuilder sb2 = new StringBuilder();
        System.out.println();
        System.out.println("Демонстрация изменения StringBuilder");
        System.out.println(new Date());
        for (int i = 0; i < count; i++) {
            sb2.append("1");
        }
        System.out.println(new Date());

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.demoString();
        m.demoStringBuffer();
    }
}
