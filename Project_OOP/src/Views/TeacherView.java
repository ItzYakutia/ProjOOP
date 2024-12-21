package Views;

import Models.Course;
import Models.Teacher;

import java.util.List;

public class TeacherView {

    // Display Sorted Teachers
    public void displaySortedTeachersByLastName(List<Teacher> teachers) {
        System.out.println("Sorted Teachers by Last Name:");
        teachers.forEach(teacher -> System.out.println("- " + teacher.getNameLast() + ", " + teacher.getNameFirst()));
    }

    // Display Teacher Courses
    public void displayTeacherCourses(List<Course> courses) {
        System.out.println("Courses assigned:");
        courses.forEach(course -> System.out.println("- " + course.getName()));
    }

    // Display Success or Error Messages
    public void displaySuccessMessage(String message) {
        System.out.println("Success: " + message);
    }

    public void displayErrorMessage(String message) {
        System.err.println("Error: " + message);
    }
}

