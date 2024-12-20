package Controllers;

import Models.*;
import Views.*;
import java.util.List;
import java.util.Map;

public class FinanceOfficeController {

    private FinanceOffice financeOffice;
    private FinanceOfficeView view;

    public FinanceOfficeController(FinanceOffice financeOffice, FinanceOfficeView view) {
        this.financeOffice = financeOffice;
        this.view = view;
    }

    public void displayProfile() {
        view.displayProfile(financeOffice);
    }

    public void processExpenseRequests(List<ExpenseRequest> requests) {
        view.displayProcessedRequests(requests);
    }

    public void manageSalaries() {
        Map<String, Double> salaries = financeOffice.getEmployeeSalaries();
        view.displaySalaryDetails(salaries);
    }

    public void updateEmployeeSalary(String userId, double salary) {
        Map<String, Double> salaries = financeOffice.getEmployeeSalaries();
        if (salaries.containsKey(userId)) {
            salaries.put(userId, salary);
            view.displaySalaryDetails(salaries);
        } else {
            System.out.println("Employee not found: " + userId);
        }
    }

    public void allocateFunds(int departmentId, double amount) {
        boolean success = financeOffice.allocateFunds(departmentId, amount);
        view.displayAllocationConfirmation(success);
    }

    public void displayTransactionLog(List<Transaction> transactions) {
        view.displayTransactionLog(transactions);
    }
}
