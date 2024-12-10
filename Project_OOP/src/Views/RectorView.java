package Views;

public class RectorView {
    public void displayUniversityBudget(double budget) {
        System.out.println("Current University Budget: $" + budget);
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
