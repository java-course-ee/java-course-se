package edu.gemini.io;

import java.io.File;

/**
 * Пример программы использования стандартного класса File
 * для рекурсивного обхода директорий, начиная с текущей
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        // Обращение к переменной среды user.dir в классе System
        // возвращает текующую директорию
        String root = System.getProperty("user.dir");
        // Входим в рекурсивную фнукцию
        m.showFileList(root);
    }

    private void showFileList(String root) {
        // Создаем объект с указанием файла/директории
        File fileRoot = new File(root);
        // Получаем список файлов и директорий в указанном файле - мы знаем что это директория
        String[] list = fileRoot.list();
        // Перебираем все файлы внути директории
        for (String s : list) {
            // Создаем объект с указанием файла/директории
            File fileLocal = new File(root + File.separator + s);
            // Печатаем
            System.out.println(fileLocal.getAbsolutePath());
            System.out.println();
            // Если этот объект тоже директория - обрабатываем его как и родителя
            // т.е. снова вызываем showFileList, только уже для новой директории
            if (fileLocal.isDirectory()) {
                showFileList(fileLocal.getAbsolutePath());
            }
        }

    }
}
