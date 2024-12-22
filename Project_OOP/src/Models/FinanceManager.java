package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FinanceManager extends Manager{
    private double budgetResponsibility;
    private double allocatedBudget;
    private List<ExpenseRequest> expenseRequests;

    public FinanceManager(String username, String password, String userId, String email,
                          String nameLast, String nameFirst, String department, int teamSize,
                          String officeLocation, double budgetResponsibility) {
        super(username, password, userId, email, nameLast, nameFirst, department, teamSize);
        this.budgetResponsibility = budgetResponsibility;
        this.allocatedBudget = 0;
        this.expenseRequests = new ArrayList<>();
    }

    // Business Logic
    public boolean approveExpenseRequest(ExpenseRequest request) {
        if (request.getAmount() <= getRemainingBudget()) {
            allocatedBudget += request.getAmount();
            request.setApproved(true);
            return true;
        } else {
            request.setApproved(false);
            return false;
        }
    }

    public double getAllocatedBudget() {
    	return allocatedBudget;
    }
    
    public void setAllocatedBudget(double allocatedBudget) {
    	this.allocatedBudget = allocatedBudget;
    }
    
    public double getRemainingBudget() {
        return budgetResponsibility - allocatedBudget;
    }

    public void addExpenseRequest(ExpenseRequest request) {
        expenseRequests.add(request);
    }

    public List<ExpenseRequest> getPendingRequests() {
        List<ExpenseRequest> pendingRequests = new ArrayList<>();
        for (ExpenseRequest request : expenseRequests) {
            if (!request.isApproved()) {
                pendingRequests.add(request);
            }
        }
        return pendingRequests;
    }

    // Getters and Setters
    public double getBudgetResponsibility() {
        return budgetResponsibility;
    }

    public void setBudgetResponsibility(double budgetResponsibility) {
        this.budgetResponsibility = budgetResponsibility;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        FinanceManager that = (FinanceManager) obj;
        return Double.compare(that.budgetResponsibility, budgetResponsibility) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), budgetResponsibility);
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nBudget Responsibility: " + budgetResponsibility +
               "\nAllocated Budget: " + allocatedBudget;
    }
    
    @Override
    public void sendMessage(String recipientUserId, String message) {
        System.out.println("Message from " + getUserId() + " to " + recipientUserId + ": " + message);
    }
}
