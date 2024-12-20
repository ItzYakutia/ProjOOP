package Views;

import Controllers.EmployeeController;
import Models.Employee;
import java.util.Scanner;

public class EmployeeView {
    private EmployeeController controller;
    private Scanner scanner;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Employee Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. List Employees");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> controller.listEmployees();
                case 0 -> System.out.println("Exiting Employee Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        controller.addEmployee(new Employee(id, name, "email@example.com", "password", department));
    }

    private void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        String employeeId = scanner.nextLine();
        controller.removeEmployee(employeeId);
    }
}
