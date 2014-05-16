package edu.gemini.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Пример вызова Stored Procedure
 * 
 * @author ASaburov
 */
public class StoredProcedureExample {

    public static void main(String[] args) {
        StoredProcedureExample spe = new StoredProcedureExample();
        spe.callStoredProcedure();
        System.out.println();
        spe.callStoredProcedureWithParam();
    }

    /**
     * Вызов процедуры без параметров
     */
    private void callStoredProcedure() {
        System.out.println("No parameters");
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                CallableStatement cs = con.prepareCall("{call get_students()}");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    String str = rs.getString("student_id") + ":" + rs.getString(2);
                    printString(str);
                }
                rs.close();
                cs.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Вызов процедуры с параметрами
     */
    private void callStoredProcedureWithParam() {
        System.out.println("With parameter");
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                CallableStatement cs = con.prepareCall("{call get_student(?)}");
                cs.setInt(1, 1);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    String str = rs.getString("student_id") + ":" + rs.getString(2);
                    printString(str);
                }
                rs.close();
                cs.close();
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
