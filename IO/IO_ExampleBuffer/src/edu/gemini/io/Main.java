package edu.gemini.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для демонстрации построчного чтения из текстового файла
 */
public class Main {

    private static final String TEST_FILE = "testFile.txt";

    public static void main(String[] args) {
        Main m = new Main();
        // Вызываем основную процедуру примера, которая может сгенерить исключения
        try {
            m.readFile();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Основная процедура демонстрации чтения строк из файла
    private void readFile() throws FileNotFoundException, IOException {
        // Открываем символьное чтение из файла созданием объекта стандартного FileReader
        // "Скрепляем его с другим считывателем, который
        BufferedReader br = new BufferedReader(new FileReader(TEST_FILE));

        String s = null;
        // Пока считанная строка не будет равна null - значит файл еще не кончился
        // и продолжаем чиать строку за строкой с помощью метода readLine
        while ((s = br.readLine()) != null) {
            // Выводим на экран считанную строку
            System.out.println("Read:" + s);
        }
    }
}
