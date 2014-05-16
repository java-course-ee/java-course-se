package edu.gemini.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Пример получения данных из базы данных
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.testDatabase();
    }

    private void testDatabase() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM st_student");
                while (rs.next()) {
                    String str = rs.getString("student_id") + ":" + rs.getString(2);
                    printString(str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printString(String str) {
        System.out.println("Student:" + str);
    }
}
