package edu.gemini.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Пример для демонстрации работы с транзакциями
 */
public class Main {

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");

            try {
                // Подтверждаем изменения
                commitStatement(con);
                // Отменяем изменения
                rollbackStatement(con);


                // Модификация через ResultSet
                modifyStudent(con);
                // Группа команд
                batchUpdate(con);
                // Группа команд 2
                batchUpdate2(con);

            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void commitStatement(Connection con) throws SQLException {
        // Выставляем ручное управление операцией commit/rollback
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO st_group (groupName, curator, speciality) VALUES ('Group 1','Curator 1','Speciality 1')");
        stmt.executeUpdate("INSERT INTO st_group (groupName, curator, speciality) VALUES ('Group 2','Curator 2','Speciality 2')");

        // Этот вызов подтверждает все изменения
        // Если закомментировать строку, то данные не будут сохранены
        con.commit();

        con.setAutoCommit(true);
    }

    private static void rollbackStatement(Connection con) throws SQLException {
        // Выставляем ручное управление операцией commit/rollback
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO st_group (groupName, curator, speciality) VALUES ('GroupR 1','CuratorR 1','SpecialityR 1')");
        stmt.executeUpdate("INSERT INTO st_group (groupName, curator, speciality) VALUES ('GroupR 2','CuratorR 2','SpecialityR 2')");

        // Этот вызов отменяет все изменения
        con.rollback();

        con.setAutoCommit(true);
    }

    private static void modifyStudent(Connection con) throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery("SELECT * FROM st_student");

            while (uprs.next()) {
                uprs.updateInt("group_id", 1);
                uprs.updateRow();
            }
            // Учтите, что можно использовать команды удаления и вставки
            // Но подерживается не всеми драйверами
            // Разобрать самостоятельно
            //uprs.deleteRow();

            //uprs.moveToInsertRow();
            //uprs.updateString("surName", "Васильев");
            //uprs.updateString("firstName", "Константин");
            //uprs.updateString("patronymic", "Валерьевич");
            //uprs.updateDate("dateOfBirth", new Date(12345));
            //uprs.updateString("sex", "M");
            //uprs.updateInt("group_id", 2);
            //uprs.updateInt("educationYear", 2011);
            //uprs.insertRow();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    private static void batchUpdate(Connection con) throws SQLException {
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();

        stmt.addBatch("INSERT INTO st_group (groupName, curator, speciality) VALUES ('GroupB 1','CuratorB 1','SpecialityB 1')");
        stmt.addBatch("INSERT INTO st_group (groupName, curator, speciality) VALUES ('GroupB 2','CuratorB 2','SpecialityB 2')");

        int[] updateCounts = stmt.executeBatch();
        con.commit();
        con.setAutoCommit(true);
    }

    private static void batchUpdate2(Connection con) throws SQLException {
        con.setAutoCommit(false);
        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO st_group (groupName, curator, speciality) VALUES (?,?,?)");

        pstmt.setString(1, "GroupBP 1");
        pstmt.setString(2, "CuratorBP 1");
        pstmt.setString(3, "SpecialityBP 1");
        pstmt.addBatch();

        pstmt.setString(1, "GroupBP 2");
        pstmt.setString(2, "CuratorBP 2");
        pstmt.setString(3, "SpecialityBP 2");
        pstmt.addBatch();

        int[] updateCounts = pstmt.executeBatch();
        con.commit();
        con.setAutoCommit(true);
    }
}
