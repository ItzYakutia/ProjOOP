package Models;

public class PerformanceReport {
    private Employee employee;
    private String feedback;
    private int rating;

    public PerformanceReport(Employee employee, String feedback, int rating) {
        this.employee = employee;
        this.feedback = feedback;
        this.rating = rating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Employee: " + employee.getNameFirst() + " " + employee.getNameLast() +
               "\nFeedback: " + feedback +
               "\nRating: " + rating;
    }
}
