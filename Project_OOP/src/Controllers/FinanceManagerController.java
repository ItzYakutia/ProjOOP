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
        double remainingBudget = financeManager.getRemainingBudget();
        BudgetReport report = new BudgetReport(financeManager.getBudgetResponsibility(), 
                                                financeManager.getAllocatedBudget(), 
                                                remainingBudget);
        view.displayBudgetReport(report);
    }

    public void approveExpenseRequest(int requestId) {
        List<ExpenseRequest> requests = financeManager.getPendingRequests();
        if (requestId < 0 || requestId >= requests.size()) {
            view.displayApprovalConfirmation(false);
            return;
        }

        ExpenseRequest request = requests.get(requestId);
        boolean isApproved = financeManager.approveExpenseRequest(request);
        view.displayApprovalConfirmation(isApproved);
    }

    public void displayPendingRequests() {
        List<ExpenseRequest> pendingRequests = financeManager.getPendingRequests();
        view.displayExpenseRequests(pendingRequests);
    }

    public void displayProfile() {
        view.displayProfile(financeManager);
    }
}
