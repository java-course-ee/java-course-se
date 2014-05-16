package edu.gemini.database.students.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ManagementSystem {

    private static Connection con;
    private static ManagementSystem instance;

    private ManagementSystem() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/st_student";
            con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    public int insertStudent(Student student) throws SQLException {
        PreparedStatement stmt = null;
        int studentId = 0;
        try {
            stmt = con.prepareStatement(
                    "INSERT INTO st_student " +
                    "(firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)", new String[]{"student_id"});
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getPatronymic());
            stmt.setString(3, student.getSurName());
            stmt.setString(4, new String(new char[]{student.getSex()}));
            stmt.setDate(5, new java.sql.Date(student.getDateOfBirth().getTime()));
            stmt.setInt(6, student.getGroupId());
            stmt.setInt(7, student.getEducationYear());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                studentId = rs.getInt(1);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return studentId;
    }

    public static void main(String[] arg) {
        Student st = new Student();
        st.setFirstName("Anton");
        st.setPatronymic("Germanovich");
        st.setSurName("Saburov");
        st.setDateOfBirth(new Date());
        st.setSex('M');
        st.setEducationYear(1984);
        try {
            int studentId = ManagementSystem.getInstance().insertStudent(st);
            System.out.println("StudentID:" + studentId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Inserted");
    }
}
