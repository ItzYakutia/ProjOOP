package Controllers;

import Models.*;
import Views.*;
import java.util.List;

public class FinanceManagerController {

    private FinanceManager financeManager;
    private FinanceManagerView view;

    public FinanceManagerController(FinanceManager financeManager, FinanceManagerView view) {
        this.financeManager = financeManager;
        this.view = view;
    }

    public void viewBudgetReport() {
        BudgetReport report = new BudgetReport(1_000_000, 600_000, 400_000);
        view.displayBudgetReport(report);
    }

    public void approveExpenseRequest(int requestId) {
        boolean isApproved = true; // Simulate approval logic
        view.displayApprovalConfirmation(isApproved);
    }

    public void generateFinancialReport() {
        FinancialReport report = new FinancialReport(1_000_000, 600_000, 200_000);
        view.displayFinancialReport(report);
    }

    public void manageFinances(int departmentId, double amount) {
        // Simulate finance management
        Allocation allocation = new Allocation(departmentId, amount);
        List<Allocation> allocations = List.of(allocation); // Placeholder
        view.displayAllocations(allocations);
    }

    public void viewTransactionHistory() {
        // Simulate transactions history
        List<Transaction> transactions = List.of(
            new Transaction("T001", "Purchase of supplies", 5000.0),
            new Transaction("T002", "Team building event", 3000.0)
        );
        view.displayTransactionHistory(transactions);
    }

    public void displayProfile() {
        view.displayProfile(financeManager);
    }
}
