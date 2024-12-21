package Views;

import Models.*;

import java.util.Comparator;
import java.util.List;

public class TeacherView {

    // Метод для отображения списка преподавателей (например, после сортировки)
    public void displaySortedTeachers(List<Teacher> teachers) {
        System.out.println("Sorted Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("- " + teacher.getNameLast() + ", " + teacher.getNameFirst());
        }
    }

    // Метод для отображения курсов преподавателя
    public void displayTeacherCourses(List<Course> courses) {
        System.out.println("Courses assigned to the teacher:");
        for (Course course : courses) {
            System.out.println("- " + course.getName() + " (Credits: " + course.getCredits() + ")");
        }
    }

    // Метод для отображения студентов, зарегистрированных на курс
    public void displayStudentsInCourse(List<Student> students) {
        System.out.println("Students registered in the course:");
        for (Student student : students) {
            System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() + " (GPA: " + student.getGpa() + ")");
        }
    }

    // Метод для отображения жалоб преподавателя
    public void displayTeacherComplaints(List<String> complaints) {
        System.out.println("Teacher's Complaints:");
        for (String complaint : complaints) {
            System.out.println("- " + complaint);
        }
    }

    // Метод для отображения сообщений об успехе
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Метод для отображения сообщений об ошибке
    public void displayErrorMessage(String message) {
        System.err.println("ERROR: " + message);
    }

    // Метод для отображения деталей курса
    public void displayCourseDetails(Course course) {
        System.out.println("Course Details:");
        System.out.println("- Name: " + course.getName());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Instructors: ");
        for (Teacher teacher : course.getAssignedTeachers()) {
            System.out.println("  * " + teacher.getNameFirst() + " " + teacher.getNameLast());
        }
        System.out.println("- Students Enrolled: " + course.getEnrolledStudents().size());
    }
     // Отображение средней оценки преподавателя
    public void displayAverageRating(Teacher teacher, double averageRating) {
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " has an average rating of " + averageRating + " stars.");
    }
}
