package Controllers;

import Models.FinanceOffice;
import Models.Employee;
import java.util.List;
import java.util.Map;

public class FinanceOfficeController {

    private FinanceOffice financeOffice;

    public FinanceOfficeController(FinanceOffice financeOffice) {
        this.financeOffice = financeOffice;
    }

    public boolean processExpenseRequest(int requestId) {
        System.out.println("Processing expense request with ID: " + requestId);
        boolean isProcessed = true; 
        return isProcessed;
    }

    public boolean allocateFunds(int departmentId, double amount) {
        System.out.println("Allocating funds to department ID: " + departmentId + " with amount: " + amount);
        boolean isAllocated = true; 
        return isAllocated;
    }

    public void generateTransactionLog() {
        System.out.println("Generating transaction log for Finance Office: " + financeOffice.getOfficeName());
    }

    public void manageSalaries(List<Employee> employees) {
        System.out.println("Managing salaries for employees in Finance Office: " + financeOffice.getOfficeName());
        for (Employee employee : employees) {
            System.out.println("Processing salary for employee: " + employee.getUserId());
        }
    }

    public void updateSalary(String userId, double salary) {
        Map<String, Double> salaries = financeOffice.getEmployeeSalaries();
        if (salaries.containsKey(userId)) {
            salaries.put(userId, salary);
            System.out.println("Updated salary for employee ID: " + userId + " to: " + salary);
        } else {
            System.out.println("Employee ID: " + userId + " not found in Finance Office.");
        }
    }
}
