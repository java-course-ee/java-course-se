package edu.javacourse.classchain.bl;

import edu.javacourse.classchain.dao.DBAccess;
import edu.javacourse.classchain.entity.Employee;
import edu.javacourse.classchain.outservice.SendMailService;

public class InternalBusinessLogic {

    private DBAccess db;
    private SendMailService mailService;

    public void setDb(DBAccess db) {
        this.db = db;
    }

    public void setMailService(SendMailService mailService) {
        this.mailService = mailService;
    }

    public void sendNotificationToAllEmployees(String text) {
        System.out.println("\t\tSending notification to all employees");
        Employee[] allEmployees = db.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println("\t\tto: " + employee.getEmail());
            mailService.sendMail("info@example.com", employee.getEmail(), text);
        }
    }

    public void addSalaryToAllEmployees(int amountToAdd) {
        System.out.println("\t\tAdd salary  to everyone: " + amountToAdd);
        Employee[] allEmployees = db.getAllEmployees();
        for (Employee employee : allEmployees) {
            employee.setSalary(employee.getSalary() + amountToAdd);
            db.saveEmployee(employee);
        }
    }

}
