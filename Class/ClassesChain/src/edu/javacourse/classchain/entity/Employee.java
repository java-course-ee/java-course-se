package edu.javacourse.classchain.entity;

import java.util.Date;

public class Employee {
    private Long id;
    private String name;
    private Date birth;
    private String email;
    private int salary;

    public Employee(Long id, String name, Date birth, String email, int salary) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
