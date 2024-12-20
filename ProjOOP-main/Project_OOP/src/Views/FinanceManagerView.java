package Views;

import Controllers.FinanceManagerController;
import Models.Student;
import java.util.List;
import java.util.Scanner;

public class FinanceManagerView {
    private FinanceManagerController controller;
    private Scanner scanner;

    public FinanceManagerView(FinanceManagerController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(List<Student> students) {
        int choice;
        do {
            System.out.println("=== Finance Manager Menu ===");
            System.out.println("1. Allocate Scholarships");
            System.out.println("2. View Budget");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> controller.allocateScholarships(students);
                case 2 -> controller.printBudget();
                case 0 -> System.out.println("Exiting Finance Manager Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}
