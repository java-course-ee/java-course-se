package edu.gemini.jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GroupSystem {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/st_student";
        Connection con = DriverManager.getConnection(url, "root", "root");
        return con;
    }

    public List<Group> findGroup() {
        List<Group> groupList = new LinkedList<Group>();

        try {
            Connection con = getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM st_group ORDER BY groupName");
                while (rs.next()) {
                    Group g = new Group(rs);
                    groupList.add(g);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return groupList;

    }
}
