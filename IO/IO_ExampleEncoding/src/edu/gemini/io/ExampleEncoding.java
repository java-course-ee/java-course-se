package edu.gemini.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Пример для демонстрации возможности устанавливать различную кодировку
 * при записи данных в файл
 * 
 * @author ASaburov
 */
public class ExampleEncoding {

    public static void main(String[] args) {
        String test = "Тестовая строка для демонстрации кодировок";
        try {
            {   // Вариант записи кодировки "cp1251" (Windows)
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("windows.txt"), "cp1251"));
                out.append(test);
                out.close();
            }
            {   // Вариант записи кодировки "UTF-8"
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("utf.txt"), "UTF-8"));
                out.append(test);
                out.close();
            }
            System.out.println("Files are created");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
