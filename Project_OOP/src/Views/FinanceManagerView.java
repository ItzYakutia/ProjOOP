package Views;

import java.util.List;

import Models.*;

public class FinanceManagerView {

    public void displayBudgetReport(BudgetReport report) {
        System.out.println("Budget Report: \n" + report);
    }

    public void displayExpenseRequests(List<ExpenseRequest> requests) {
        System.out.println("Expense Requests:");
        for (ExpenseRequest request : requests) {
            System.out.println(request);
        }
    }

    public void displayApprovalConfirmation(boolean success) {
        if (success) {
            System.out.println("Expense request approved successfully.");
        } else {
            System.out.println("Failed to approve the expense request.");
        }
    }

    public void displayFinancialReport(FinancialReport report) {
        System.out.println("Financial Report:\n" + report);
    }

    public void displayAllocations(List<Allocation> allocations) {
        System.out.println("Allocations:");
        for (Allocation allocation : allocations) {
            System.out.println(allocation);
        }
    }

    public void displayTransactionHistory(List<Transaction> transactions) {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void displayMessages(List<Message> messages) {
        System.out.println("Messages:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    public void displayProfile(FinanceManager manager) {
        System.out.println("Finance Manager Profile:\n" + manager);
    }
}
