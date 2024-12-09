public class Rector {
    private static Rector instance;
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

    public void manageBudget(double amount) throws InsufficientFundsException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new InsufficientFundsException("Not enough budget for this operation!");
        }
        universityBudget += amount;
        System.out.println("Updated budget: $" + universityBudget);
    }

    public String getName() {
        return name;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }
}
