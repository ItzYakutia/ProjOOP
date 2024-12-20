package Controllers;

import Models.Course;
import Models.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Course> registeredCourses;

    public StudentController() {
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            System.out.println("Course registered: " + course.getCourseName());
        } else {
            System.out.println("You are already registered for this course.");
        }
    }

    public void viewCourses() {
        System.out.println("Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println(course);
        }
    }
}
