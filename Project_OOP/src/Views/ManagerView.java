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
    }

    public void displayRequests(List<Request> requests) {
        System.out.println("Requests:");
        for (Request request : requests) {
            System.out.println(request);
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

    public void displayCourses(List<Course> courses) {
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
