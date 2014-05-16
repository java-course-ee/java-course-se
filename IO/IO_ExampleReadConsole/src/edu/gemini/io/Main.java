package edu.gemini.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Пример считывания строки с консоли
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Открываем построчный считыватель BufferedReader и связываем его
            // с потоком символов InputStreamReader. А его в свою очередь
            // направляем на стандартный поток ввода - System.in. Это ввод с клавиатуры
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Выводим приглашение для ввода строки
            System.out.print("Enter line:");
            // Читаем строку с консоли
            String s = br.readLine();
            // Печатаем
            System.out.println("Line:" + s);

            // Важные оболочки вокруг элементарных типов данных
            // позволяют из строки получать числа
            // Если вводить строку как число - код будет работать корректно
            // Иначе будет исключение java.lang.NumberFormatException
            int a1 = Integer.parseInt(s);
            long a2 = Long.parseLong(s);
            float a3 = Float.parseFloat(s);
            double a4 = Double.parseDouble(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
