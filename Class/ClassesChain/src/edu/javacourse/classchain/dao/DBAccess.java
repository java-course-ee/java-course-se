package edu.javacourse.classchain.dao;

import edu.javacourse.classchain.entity.Employee;

import java.util.Date;
import java.util.List;

public class DBAccess {

    public Employee getById(Long id) {
        return new Employee(id, "Employee " + id, new Date(), "user-" + id + "@example.ru", 00000);
    }

    public List<Employee> getAllEmployees() {
        System.out.println("\t\t\tGetting list of all employees");
        return List.of(
                new Employee(1L, "Employee 1", new Date(), "user1@example.ru", 11111),
                new Employee(2L, "Employee 2", new Date(), "user2@example.ru", 22222),
                new Employee(3L, "Employee 3", new Date(), "user3@example.ru", 33333)
        );
    }

    public void addNewEmployee(Employee employee) {
        System.out.println("\t\t\tAdded new Employee");
    }

    public void saveEmployee(Employee employee) {
        System.out.println("\t\t\tEmployee has been saved");
    }

}
