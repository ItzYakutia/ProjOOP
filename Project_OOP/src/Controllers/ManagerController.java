package Controllers;

import Models.*;
import Views.ManagerView;

import java.util.List;

public class ManagerController {
    private Manager manager;
    private ManagerView view;

    public ManagerController(Manager manager, ManagerView view) {
        this.manager = manager;
        this.view = view;
    }

    public void showManagedEmployees() {
        List<Employee> employees = manager.getManagedEmployees();
        view.displayManagedEmployees(employees);
    }

    public void viewEmployeeDetails(Employee employee) {
        view.displayEmployeeDetails(employee);
    }

    public void createPerformanceReport(Employee employee, String feedback, int rating) {
        PerformanceReport report = manager.createPerformanceReport(employee, feedback, rating);
        view.displayPerformanceReport(report);
    }

    public void manageRequests() {
        List<Request> requests = manager.getRequests();
        view.displayRequests(requests);
    }

    public void handleRequest(Request request) {
        manager.handleRequest(request);
        view.displayMessage("Request handled: " + request);
    }

    public void viewMessages() {
        List<Message> messages = manager.getMessages();
        view.displayMessages(messages);
    }

    public void viewProfile() {
        view.displayProfile(manager);
    }
}
