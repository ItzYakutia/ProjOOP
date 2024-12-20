package Models;

public class FinanceManager extends User {
    private double budget;

    public FinanceManager(String id, String name, String email, String password, double budget) {
        super(id, name, email, password);
        this.budget = budget;
    }

    public double getBudget() { return budget; }

    @Override
    public String toString() {
        return "FinanceManager{" + "budget=" + budget + ", " + super.toString() + '}';
    }
}
