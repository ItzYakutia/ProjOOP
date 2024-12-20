package Views;

import Controllers.AdminController;
import Models.Admin;
import java.util.Scanner;

public class AdminView {
    private AdminController controller;
    private Scanner scanner;

    public AdminView(AdminController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. List Users");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> removeUser();
                case 3 -> controller.listUsers();
                case 0 -> System.out.println("Exiting Admin Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addUser() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        controller.addUser(new Admin(id, name, email, password));
    }

    private void removeUser() {
        System.out.print("Enter User ID to remove: ");
        String userId = scanner.nextLine();
        controller.removeUser(userId);
    }
}
