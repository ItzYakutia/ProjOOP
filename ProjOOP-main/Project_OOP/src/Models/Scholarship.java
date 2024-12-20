package Models;

public class Scholarship {
    private double amount;
    private String type;

    public Scholarship(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() { return amount; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Scholarship{" + "amount=" + amount + ", type='" + type + '\'' + '}';
    }
}
