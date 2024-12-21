package Models;

public class ExpenseRequest {
    private int requestId;
    private String description;
    private double amount;
    private boolean approved;

    public ExpenseRequest(int requestId, String description, double amount, boolean approved) {
        this.requestId = requestId;
        this.description = description;
        this.amount = amount;
        this.approved = approved;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "ExpenseRequest{" +
                "requestId=" + requestId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", approved=" + approved +
                '}';
    }
}
