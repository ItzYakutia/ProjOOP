package Models;

public class BudgetReport {
    private double totalBudget;
    private double utilizedBudget;
    private double remainingBudget;

    public BudgetReport(double totalBudget, double utilizedBudget, double remainingBudget) {
        this.totalBudget = totalBudget;
        this.utilizedBudget = utilizedBudget;
        this.remainingBudget = remainingBudget;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getUtilizedBudget() {
        return utilizedBudget;
    }

    public void setUtilizedBudget(double utilizedBudget) {
        this.utilizedBudget = utilizedBudget;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    @Override
    public String toString() {
        return "Total Budget: " + totalBudget +
               "\nUtilized Budget: " + utilizedBudget +
               "\nRemaining Budget: " + remainingBudget;
    }
}

