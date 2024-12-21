package Models;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    private String department;
    private int teamSize;
    private List<Employee> managedEmployees = new ArrayList<>();
    private List<Request> requests = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private List<PerformanceReport> performanceReports = new ArrayList<>();

    public Manager(String username, String password, String userId, String email, 
                   String nameLast, String nameFirst, String department, int teamSize) {
        super(username, password, userId, email, nameLast, nameFirst);
        this.department = department;
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void addEmployee(Employee employee) {
        managedEmployees.add(employee);
    }

    public PerformanceReport createPerformanceReport(Employee employee, String feedback, int rating) {
        PerformanceReport report = new PerformanceReport(employee, feedback, rating);
        performanceReports.add(report);
        return report;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void approveRequest(Request request) {
        request.approve();
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nDepartment: " + department +
               "\nTeam Size: " + teamSize;
    }

    @Override
    public void receiveNotification(String message) {
    }
}
