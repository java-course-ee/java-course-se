package edu.gemini.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.copyTextFile();
    }

    private void copyTextFile() throws IOException {
        // Открываем файл на чтение через стандартный класс FileReader
        FileReader in = new FileReader("farrago.txt");

        // Открываем файл на запись через стандартный класс FileWriter.
        // Если такой файл существует - он будет перезаписан
        FileWriter out = new FileWriter("outagain.txt");

        // Второй параметр выставленный в true позволяет не затирать новый файл,
        // а добавлять в него. Можно попробовать :)
        //FileWriter out = new FileWriter("outagain.txt", true);

        System.out.println("Начинаем считывать файл");
        // В цикле считывается файл посимвольно до тех пор, пока считывание
        // не вернет значение -1. Оно означает, что файл закончился
        int c;
        while ((c = in.read()) != -1) {
            // Записываем считанный символ в другой файл
            out.write(c);
        }
        System.out.println("Файл скопирован");

        // ОБЯЗАТЕЛЬНО !!! Надо закрывать открытые потоки ввода/вывода
        in.close();
        out.close();

    }
}
