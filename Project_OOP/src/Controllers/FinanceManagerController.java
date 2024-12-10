package Controllers;

import Models.FinanceManager;
import java.util.List;

public class FinanceManagerController {

    private FinanceManager financeManager;

    public FinanceManagerController(FinanceManager financeManager) {
        this.financeManager = financeManager;
    }

    public void viewBudgetReport() {
        System.out.println("Viewing budget report for: " + financeManager.getDepartment());
        //
    }

    public boolean approveExpenseRequest(int requestId) {
        System.out.println("Approving expense request with ID: " + requestId);
        boolean isApproved = true; 
        return isApproved;
    }

    public void generateFinancialReport() {
        System.out.println("Generating financial report for department: " + financeManager.getDepartment());
    }

    public void manageFinances(int departmentId, double amount) {
        System.out.println("Managing finances for department ID: " + departmentId + " with amount: " + amount);
    }
}
