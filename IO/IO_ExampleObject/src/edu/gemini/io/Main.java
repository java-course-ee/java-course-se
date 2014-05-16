package edu.gemini.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для демонстрации записи и считывания объектов из файла
 */
public class Main {

    private static final String FILE_NAME = "object.tmp";

    public static void main(String[] args) {
        Main p = new Main();

        try {
            p.saveObject();
            System.out.println();
            p.loadObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Метод для записи объектов в файл
    private void saveObject() throws IOException {
        System.out.println("Write to file");

        // Создаем два объекта mo1 и mo2
        MyObject mo1 = new MyObject("Anton Saburov", 110.0, new Date());
        printObject(mo1);
        MyObject mo2 = new MyObject("Павел Сикорски", 150.0, new Date());
        printObject(mo2);

        // Открываем поток FileOutputStream на файл для записи
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        // "Соединяем" поток ObjectOutputStream с FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Записываем оба объекта в файл
        oos.writeObject(mo1);
        oos.writeObject(mo2);

        oos.close();
    }

    private void loadObject() throws IOException, ClassNotFoundException {
        System.out.println("Read from file");

        // Открываем поток FileInputStream на файл для считывания
        FileInputStream fis = new FileInputStream(FILE_NAME);
        // "Соединяем" поток ObjectInputStream с FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Считываем объект и сразу печатаем то, что считали
        printObject(ois.readObject());
        // Считываем объект и сразу печатаем то, что считали
        printObject(ois.readObject());

        ois.close();
    }

    private void printObject(Object mo) {
        System.out.println(mo);
    }
}

/**
 * Возможно такое объявление класса для внутреннего использования - в том же файле
 * Обратить внимание на то, что класс реализует интерфейс Serializable.
 * Если этого не сделать. то объект не может быть записан в поток.
 * И выпадет исключение - java.io.NotSerializableException
 */
class MyObject implements Serializable {

    // Объявляем некоторые поля (типы которых тоже реализуют Serializable)
    private String fieldString;
    private Double fieldDouble;
    private Date fieldDate;

    public MyObject(String fieldString, Double fieldDouble, Date fieldDate) {
        this.fieldString = fieldString;
        this.fieldDouble = fieldDouble;
        this.fieldDate = fieldDate;
    }

    public Date getFieldDate() {
        return fieldDate;
    }

    public void setFieldDate(Date fieldDate) {
        this.fieldDate = fieldDate;
    }

    public Double getFieldDouble() {
        return fieldDouble;
    }

    public void setFieldDouble(Double fieldDouble) {
        this.fieldDouble = fieldDouble;
    }

    public String getFieldString() {
        return fieldString;
    }

    public void setFieldString(String fieldString) {
        this.fieldString = fieldString;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "String=" + fieldString + ", Double=" + fieldDouble + " Date=" + sdf.format(fieldDate);
    }
}
