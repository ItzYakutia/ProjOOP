package Controllers;

import Models.Employee;

public class ManagerController {
    public void assignTask(Employee employee, String task) {
        System.out.println("Task \"" + task + "\" assigned to: " + employee.getName());
    }
}
