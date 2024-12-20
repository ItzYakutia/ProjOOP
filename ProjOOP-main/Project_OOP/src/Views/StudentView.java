package Views;

import Controllers.StudentController;
import Models.Course;
import java.util.Scanner;

public class StudentView {
    private StudentController controller;
    private Scanner scanner;

    public StudentView(StudentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Register Course");
            System.out.println("2. View Courses");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerCourse();
                case 2 -> controller.viewCourses();
                case 0 -> System.out.println("Exiting Student Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void registerCourse() {
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        controller.registerCourse(new Course(courseName, courseCode, 3, null));
    }
}
