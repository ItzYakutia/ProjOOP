package Models;

public class FinanceManager extends Manager {
    private double budgetResponsibility;

    public FinanceManager(String username, String password, String userId, String email, 
                          String nameLast, String nameFirst, String department, int teamSize, 
                          String officeLocation, double budgetResponsibility) {
        super(username, password, userId, email, nameLast, nameFirst, department, teamSize);
        this.budgetResponsibility = budgetResponsibility;
    }

    public double getBudgetResponsibility() {
        return budgetResponsibility;
    }

    public void setBudgetResponsibility(double budgetResponsibility) {
        this.budgetResponsibility = budgetResponsibility;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nBudget Responsibility: " + budgetResponsibility;
    }
}
