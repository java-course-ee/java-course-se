package edu.gemini.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author ASaburov
 * 
 * Пример работы с BLOB полями в MySQL.
 */
public class DatabaseBlob {

    public static void main(String[] args) {
        DatabaseBlob db = new DatabaseBlob();
        // Вставка картинки в базу
        int imageId = db.writeBlob();
        System.out.println("Запись завершена");
        System.out.println("Image ID:" + imageId);
        // Чтение картинки из базы
        db.readBlob(imageId);
        System.out.println("Чтение завершено - копия картинки в файле 'mapCopy.png'");
    }

    private int writeBlob() {
        Connection con = null;
        int imageId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO st_image (image) values (?)",
                        new String[]{"image_id"});
                // Открываем поток через файл чтобы определить его размер
                File file = new File("map.png");
                // Открываем поток
                InputStream fis = new FileInputStream(file);
                // Устанавливаем параметр в виде потока
                stmt.setBinaryStream(1, fis, (int) file.length());
                // Выполняем SQL-запрос
                stmt.executeUpdate();

                // Получаем данные о вставленном ID
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    imageId = rs.getInt(1);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return imageId;
    }

    private void readBlob(int imageId) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT image FROM st_image WHERE image_id=?");
                stmt.setInt(1, imageId);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    // Читаем BLOB
                    Blob image = rs.getBlob("image");
                    // Открываем поток для чтения из блоба
                    InputStream in = image.getBinaryStream();
                    // И пишем все в файл
                    FileOutputStream fos = new FileOutputStream("mapCopy.png");
                    int length = 0;
                    byte[] buffer = new byte[1024];
                    while ((length = in.read(buffer)) != -1) {
                        fos.write(buffer, 0, length);
                    }
                    in.close();
                    fos.close();
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
