package Views;

import Controllers.TeacherController;
import Models.Mark;
import java.util.Scanner;

public class TeacherView {
    private TeacherController controller;
    private Scanner scanner;

    public TeacherView(TeacherController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Teacher Menu ===");
            System.out.println("1. Assign Mark");
            System.out.println("2. View Marks");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> assignMark();
                case 2 -> controller.viewMarks();
                case 0 -> System.out.println("Exiting Teacher Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void assignMark() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Attendance Mark: ");
        int attendance = scanner.nextInt();
        System.out.print("Enter Midterm Mark: ");
        int midterm = scanner.nextInt();
        System.out.print("Enter Final Exam Mark: ");
        int finalExam = scanner.nextInt();

        controller.assignMark(studentId, new Mark(attendance, midterm, finalExam));
    }
}
