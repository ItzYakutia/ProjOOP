package Views;

import Models.*;

import java.util.List;

public class CourseView {

    // Отображение успешного сообщения
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Отображение сообщения об ошибке
    public void displayErrorMessage(String message) {
        System.err.println("ERROR: " + message);
    }

    // Отображение информации о курсе
    public void displayCourseInfo(Course course) {
        System.out.println("Course Info:");
        System.out.println("- ID: " + course.getCourseId());
        System.out.println("- Name: " + course.getName());
        System.out.println("- Description: " + course.getDescription());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Students Enrolled: " + course.getStudents().size());
        System.out.println("- Teachers Assigned: " + course.getTeachers().size());
    }

    // Отображение отсортированных студентов
    public void displaySortedStudents(List<Student> students, String criterion) {
        System.out.println("Students sorted by " + criterion + ":");
        for (Student student : students) {
            System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() +
                    " (GPA: " + student.getGpa() + ")");
        }
    }
}
