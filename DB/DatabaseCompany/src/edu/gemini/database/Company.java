package edu.gemini.database;

/**
 * Класс для хранения данных о компании.
 * 
 * @author ASaburov
 */
public class Company {

    private Integer companyId;
    private String companyName;

    public Company() {
    }

    public Company(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName=" + companyName + '}';
    }
}
