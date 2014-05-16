package edu.gemini.database;

import java.util.List;

/**
 * Пример работы с базой данных с учетом русских букв. Более подробно смотри
 * комментарии к классы CompanyDB
 * 
 * @author ASaburov
 */
public class DatabaseCompany {

    public static void main(String[] args) throws Exception {
        CompanyDB cd = CompanyDB.getInstance();
        List<Company> copmanies = cd.getCompaniesByPattern("ин");
        for(Company c: copmanies) {
            System.out.println(c);
        }
    }
}
