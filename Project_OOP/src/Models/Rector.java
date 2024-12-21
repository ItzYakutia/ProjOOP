package Models;

public class Rector extends Employee {
    private double universityBudget;

    public Rector(String username, String userId, String firstName, String lastName, String email, double budget, String password) {
        super(username, userId, firstName, lastName, email, password);
        this.universityBudget = budget;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }

    public void manageBudget(double amount) throws IllegalArgumentException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new IllegalArgumentException("Not enough budget to perform this operation!");
        }
        universityBudget += amount;
        System.out.println("Budget updated. Current budget: " + universityBudget);
    }

    public void approveDeanDecision(String decision) {
        System.out.println("Rector " + getNameFirst() + " approved the dean's decision: " + decision);
    }

    public void allocateFunding(String facultyName, double amount) throws IllegalArgumentException {
        if (amount > universityBudget) {
            throw new IllegalArgumentException("Not enough budget to allocate " + amount + " to " + facultyName);
        }
        universityBudget -= amount;
        System.out.println("Allocated " + amount + " to " + facultyName + ". Remaining budget: " + universityBudget);
    }

    public void signAgreement(String agreementName) {
        System.out.println("Rector " + getNameFirst() + " signed the agreement: " + agreementName);
    }

	@Override
	public void receiveNotification(String message) {		
	}
}
