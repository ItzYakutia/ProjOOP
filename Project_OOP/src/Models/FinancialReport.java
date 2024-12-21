package Models;

public class FinancialReport {
    private double totalIncome;
    private double totalExpenses;
    private double netIncome;

    public FinancialReport(double totalIncome, double totalExpenses, double netIncome) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netIncome = netIncome;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "totalIncome=" + totalIncome +
                ", totalExpenses=" + totalExpenses +
                ", netIncome=" + netIncome +
                '}';
    }
}
