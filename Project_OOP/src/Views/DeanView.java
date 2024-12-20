package Views;

import Models.*;
import java.util.List;
import java.util.Scanner;

public class DeanView {
    private Scanner scanner;

    public DeanView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(Dean dean) {
        while (true) {
            System.out.println("=== Dean Menu ===");
            System.out.println("1. Manage Faculty");
            System.out.println("2. Approve Research Funding");
            System.out.println("3. Review Course Proposals");
            System.out.println("4. Assign Teacher to Course");
            System.out.println("5. Sign Administrative Document");
            System.out.println("6. View Student Performance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> manageFaculty(dean);
                case 2 -> approveFunding(dean);
                case 3 -> reviewCourseProposals(dean);
                case 4 -> assignTeacherToCourse(dean);
                case 5 -> signDocument(dean);
                case 6 -> viewStudentPerformance(dean);
                case 0 -> {
                    System.out.println("Exiting Dean Menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void manageFaculty(Dean dean) {
        System.out.print("Enter department name: ");
        String department = scanner.next();
        System.out.print("Activate (true) or Deactivate (false): ");
        boolean action = scanner.nextBoolean();
        dean.manageFaculty(department, action);
        System.out.println("Faculty " + department + " has been " + (action ? "activated" : "deactivated"));
    }

    public void approveFunding(Dean dean) {
        System.out.print("Enter Research ID: ");
        String researchId = scanner.next();
        System.out.print("Enter funding amount: ");
        double amount = scanner.nextDouble();
        try {
            dean.approveResearchFunding(researchId, amount);
            System.out.println("Funding approved for Research ID: " + researchId + " with amount: $" + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reviewCourseProposals(Dean dean) {
        System.out.println("Enter course proposals (stubbed for now):");
        List<Course> proposals = List.of(new Course("Course1", "C101", 3, null));
        dean.reviewCourseProposals(proposals);
        System.out.println("Reviewed course proposals:");
        for (Course course : proposals) {
            System.out.println("- " + course.getName());
        }
    }

    public void assignTeacherToCourse(Dean dean) {
        System.out.print("Enter teacher name: ");
        String teacherName = scanner.next();
        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        Teacher teacher = new Teacher("username", "password", "T001", teacherName, "LastName", "email@example.com", "CS");
        Course course = new Course(courseName, "C101", 3, null);
        dean.assignTeacherToCourse(teacher, course);
        System.out.println("Assigned teacher " + teacherName + " to course " + courseName);
    }

    public void signDocument(Dean dean) {
        System.out.print("Enter document name: ");
        String document = scanner.next();
        dean.signDocument(document);
        System.out.println("Document signed: " + document);
    }

    public void viewStudentPerformance(Dean dean) {
        System.out.println("Enter student list (stubbed for now):");
        List<Student> students = List.of(new Student("username", "password", "S001", "John", "Doe", "john@example.com", "CS", 2, 3.7));
        dean.viewStudentPerformance(students);
        System.out.println("Displayed student performance:");
        for (Student student : students) {
            System.out.println(student.getNameFirst() + " " + student.getNameLast() + " - GPA: " + student.getGpa());
        }
    }
}
