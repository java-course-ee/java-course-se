package edu.gemini.jndi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GroupSystem {

    private Connection getConnection() throws SQLException {
        try {
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/regionDS");
            Connection con = dataSource.getConnection();
            return con;
        } catch (NamingException e) {
            throw new SQLException(e);
        }
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return groupList;

    }
}
