package edu.gemini.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с базой данных.
 * Используется шаблон singletone.
 * 
 * @author ASaburov
 */
public class CompanyDB {

    private static Connection con;
    private static CompanyDB instance;

    private CompanyDB() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Обратите внимание на characterEncoding=UTF-8 - указывает кодировку. 
            // Важно для русских букв
            String url = "jdbc:mysql://localhost:3306/st_student?characterEncoding=UTF-8";
            con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized CompanyDB getInstance() throws Exception {
        if (instance == null) {
            instance = new CompanyDB();
        }
        return instance;
    }

    /**
     * Получить список фирм в названии которых есть строка (параметр pattern)
     * 
     * @param pattern - подстрока в имени компании
     * @return Список фирм
     * @throws SQLException 
     */
    public List<Company> getCompaniesByPattern(String pattern) throws SQLException {
        List<Company> companies = new ArrayList<Company>();

        PreparedStatement stmt = con.prepareStatement(
                "SELECT company_id, companyName FROM st_company WHERE companyName LIKE ?");
        // Шаблон дополняется символами % чтобы корректно работал LIKE
        stmt.setString(1, "%" + pattern + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Company st = new Company(rs.getInt("company_id"), rs.getString("companyName"));

            companies.add(st);
        }

        return companies;
    }
}
