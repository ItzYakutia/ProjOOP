package Views;

import java.util.List;

public class FinanceOfficeView {

    public void displayProcessedRequests(List<ExpenseRequest> requests) {
        System.out.println("Processed Expense Requests:");
        for (ExpenseRequest request : requests) {
            System.out.println(request);
        }
    }

    public void displaySalaryDetails(List<Salary> salaries) {
        System.out.println("Salary Details:");
        for (Salary salary : salaries) {
            System.out.println(salary);
        }
    }

    public void displayInvoiceDetails(List<Invoice> invoices) {
        System.out.println("Invoice Details:");
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public void displayAllocationConfirmation(boolean success) {
        if (success) {
            System.out.println("Allocation completed successfully.");
        } else {
            System.out.println("Allocation failed.");
        }
    }

    public void displayTransactionLog(List<Transaction> transactions) {
        System.out.println("Transaction Log:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void displayCommunicationMessages(List<Message> messages) {
        System.out.println("Messages:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    public void displayProfile(FinanceOffice office) {
        System.out.println("Finance Office Profile:");
        System.out.println(office);
    }
}
