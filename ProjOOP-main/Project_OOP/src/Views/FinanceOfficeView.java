package Views;

import Controllers.FinanceOfficeController;
import java.util.Scanner;

public class FinanceOfficeView {
    private FinanceOfficeController controller;
    private Scanner scanner;

    public FinanceOfficeView(FinanceOfficeController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Finance Office Menu ===");
            System.out.println("1. Manage Funds");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageFunds();
                case 0 -> System.out.println("Exiting Finance Office Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void manageFunds() {
        System.out.print("Enter Amount to Manage: ");
        double amount = scanner.nextDouble();
        controller.manageFunds(amount);
    }
}
