package Views;

import Controllers.RectorController;
import Models.Course;
import java.util.List;
import java.util.Scanner;

public class RectorView {
    private RectorController controller;
    private Scanner scanner;

    public RectorView(RectorController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(List<Course> courses) {
        System.out.println("=== Rector Menu ===");
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.print("Enter Course Name to Approve: ");
        String courseName = scanner.nextLine();
        controller.approveCourse(courses, new Course(courseName, "", 3, null));
    }
}
