package Models;

public class Rector {
    private static Rector instance; // Singleton instance
    private String name;
    private double universityBudget;

    private Rector(String name, double budget) {
        this.name = name;
        this.universityBudget = budget;
    }

    public static Rector getInstance(String name, double budget) {
        if (instance == null) {
            instance = new Rector(name, budget);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }

    public void manageBudget(double amount) throws InsufficientFundsException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new InsufficientFundsException("Not enough budget for this operation!");
        }
        universityBudget += amount;
    }

    public void assignSupervisor(Researcher researcher) throws LowHIndexException {
        if (researcher.getHIndex() < 3) {
            throw new LowHIndexException("H-Index is too low for supervising!");
        }
        System.out.println("Supervisor assigned: " + researcher.getName());
    }
}
