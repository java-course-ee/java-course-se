package edu.gemini.database.students.logic;

import java.text.DateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable {

    private int studentId;
    private String firstName;
    private String surName;
    private String patronymic;
    private Date dateOfBirth;
    private char sex;
    private int groupId;
    private int educationYear;

    public Student() {
    }

    public Student(ResultSet rs) throws SQLException {
        setStudentId(rs.getInt(1));
        setFirstName(rs.getString(2));
        setPatronymic(rs.getString(3));
        setSurName(rs.getString(4));
        setSex(rs.getString(5).charAt(0));
        setDateOfBirth(rs.getDate(6));
        setGroupId(rs.getInt(7));
        setEducationYear(rs.getInt(8));
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return surName + " " + firstName + " " + patronymic + ", " 
                + DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirth)
                + ", Группа ИД=" + groupId + " Год:" + educationYear;
    }

    // Метод для сравнения
    public int compareTo(Object obj) {
        // Collator - специальный класс для сравнения строк в зависимости
        // от локализации
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}