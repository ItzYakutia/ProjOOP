package Controllers;

import Models.Employee;
import Models.Researcher;
import Views.EmployeeView;

public class EmployeeController {
    private Employee employee;
    private EmployeeView employeeView;

    public EmployeeController(Employee employee, EmployeeView employeeView) {
        this.employee = employee;
        this.employeeView = employeeView;
    }

    public void createResearcherProfile() {
        try {
            employee.createResearcherProfile(); 
            employeeView.displayResearcherProfileCreated(employee.getResearcherProfile());
        } catch (IllegalArgumentException e) {
            employeeView.displayResearcherAssignmentError(e.getMessage());
        }
    }
}
