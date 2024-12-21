package Controllers;

import Models.*;
import Views.*;
import java.util.List;

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

    public void updateEmployeeSalary(String userId, double salary) {
        boolean success = financeOffice.updateEmployeeSalary(userId, salary);
        if (success) {
            view.displayMessage("Salary updated successfully.");
        } else {
            view.displayMessage("Error: Employee not found.");
        }
    }

    public void manageSalaries() {
        view.displayMessage(financeOffice.getSalaryDetails());
    }

    public void allocateFunds(int departmentId, double amount) {
        boolean success = financeOffice.allocateFunds(departmentId, amount);
        view.displayAllocationConfirmation(success);
    }

    public void displayTransactionLog(List<Transaction> transactions) {
        String log = financeOffice.generateTransactionLog(transactions);
        view.displayMessage(log);
    }
}
