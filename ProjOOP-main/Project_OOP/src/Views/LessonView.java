package Views;

import Controllers.LessonController;
import Models.Lesson;
import Models.LessonType;
import Models.Course;
import java.util.Scanner;

public class LessonView {
    private LessonController controller;
    private Scanner scanner;

    public LessonView(LessonController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Lesson Menu ===");
            System.out.println("1. Add Lesson");
            System.out.println("2. Remove Lesson");
            System.out.println("3. List Lessons");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addLesson();
                case 2 -> removeLesson();
                case 3 -> controller.listLessons();
                case 0 -> System.out.println("Exiting Lesson Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addLesson() {
        System.out.print("Enter Lesson ID: ");
        String lessonId = scanner.nextLine();
        System.out.print("Enter Lesson Type (LECTURE/PRACTICE): ");
        String type = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        controller.addLesson(new Lesson(lessonId, LessonType.valueOf(type.toUpperCase()), new Course(courseName, "101", 3, null)));
    }

    private void removeLesson() {
        System.out.print("Enter Lesson ID to remove: ");
        String lessonId = scanner.nextLine();
        controller.removeLesson(lessonId);
    }
}
