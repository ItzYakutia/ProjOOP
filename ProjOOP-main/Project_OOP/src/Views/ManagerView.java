package Views;

import Controllers.ManagerController;
import Models.Employee;
import java.util.Scanner;

public class ManagerView {
    private ManagerController controller;
    private Scanner scanner;

    public ManagerView(ManagerController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Manager Menu ===");
            System.out.println("1. Assign Task");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> assignTask();
                case 0 -> System.out.println("Exiting Manager Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void assignTask() {
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();
        System.out.print("Enter Task: ");
        String task = scanner.nextLine();

        controller.assignTask(new Employee("1", employeeName, "email@example.com", "password", "Department"), task);
    }
}
