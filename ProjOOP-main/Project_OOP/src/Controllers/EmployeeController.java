package Controllers;

import Models.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private List<Employee> employees;

    public EmployeeController() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void removeEmployee(String employeeId) {
        boolean removed = employees.removeIf(e -> e.getId().equals(employeeId));
        if (removed) {
            System.out.println("Employee removed with ID: " + employeeId);
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    public void listEmployees() {
        System.out.println("Listing all employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
