package Controllers;

import Models.Manager;
import Models.Course;
import Models.Student;
import Models.Teacher;
import java.util.ArrayList;
import java.util.List;

public class ManagerController {

    private List<Course> courses;

    public ManagerController() {
        this.courses = new ArrayList<>();
    }

    public void createLesson(Course course) {
        System.out.println("Lesson created for course: " + course.getTitle());
    }

    public void createCourse(String title) {
        Course newCourse = new Course(title);
        courses.add(newCourse);
        System.out.println("Course created with title: " + title);
    }

    public void approveRegistration(String studentId, Course course, boolean isApproved) {
        if (isApproved) {
            System.out.println("Registration approved for student ID: " + studentId + " in course: " + course.getTitle());
        } else {
            System.out.println("Registration denied for student ID: " + studentId + " in course: " + course.getTitle());
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getTitle());
    }

    public void assignTeacher(String email, String lessonId) {
        System.out.println("Teacher with email: " + email + " assigned to lesson ID: " + lessonId);
    }

    public void createReport() {
        System.out.println("Report created.");
        // Implement report generation logic here
    }

    public void manageNews(String text, String title, String type) {
        switch (type.toLowerCase()) {
            case "add":
                System.out.println("News added: " + title);
                break;
            case "edit":
                System.out.println("News edited: " + title);
                break;
            case "delete":
                System.out.println("News deleted: " + title);
                break;
            default:
                System.out.println("Invalid news management type: " + type);
        }
    }

    public Student viewStudent(String studentId) {
        System.out.println("Viewing details for student ID: " + studentId);
        //Student details
    }

    public Teacher viewTeacher(String email) {
        System.out.println("Viewing details for teacher ID: " + email);
        //Teacher details
    }

    public List<Course> viewCourses() {
        return courses;
    }
}
