package Views;

import Models.*;
import java.util.List;

public class ManagerView {

    public void displayManagedEmployees(List<Employee> employees) {
        System.out.println("Managed Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void displayEmployeeDetails(Employee employee) {
        System.out.println("Employee Details:");
        System.out.println(employee);
    }

    public void displayPerformanceReport(PerformanceReport report) {
        System.out.println("Performance Report:");
        System.out.println(report);
    }

    public void displayCreateReportForm(Employee employee) {
        System.out.println("Create a new Performance Report for Employee:");
        System.out.println("Employee: " + employee.getNameFirst() + " " + employee.getNameLast());
        System.out.println("Please enter the report details.");
    }

    public void displayReportConfirmation(boolean success) {
        if (success) {
            System.out.println("Performance report created successfully.");
        } else {
            System.out.println("Failed to create the performance report.");
        }
    }

    public void displayRequests(List<Request> requests) {
        System.out.println("Requests:");
        for (Request request : requests) {
            System.out.println(request);
        }
    }

    public void displayRequestApprovalForm(Request request) {
        System.out.println("Review Request:");
        System.out.println(request);
        System.out.println("Approve or deny this request.");
    }

    public void displayApprovalConfirmation(boolean success) {
        if (success) {
            System.out.println("Request approved successfully.");
        } else {
            System.out.println("Failed to approve the request.");
        }
    }

    public void displayMessages(List<Message> messages) {
        System.out.println("Messages:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    public void displayProfile(Manager manager) {
        System.out.println("Manager Profile:");
        System.out.println(manager);
    }
}
