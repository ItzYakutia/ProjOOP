package Controllers;

import Models.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerController {

    private List<Course> courses;
    private List<Student> students;
    private List<Teacher> teachers;

    public ManagerController() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void createLesson(Course course) {
        System.out.println("Lesson created for course: " + course.getName());
    }

    public void createCourse(String title) {
        Course newCourse = new Course(title, title, title, 0, null, null, null, null);
        courses.add(newCourse);
        System.out.println("Course created with title: " + title);
    }

    public void approveRegistration(String studentId, Course course, boolean isApproved) {
        if (isApproved) {
            System.out.println("Registration approved for student ID: " + studentId + " in course: " + course.getName());
        } else {
            System.out.println("Registration denied for student ID: " + studentId + " in course: " + course.getName());
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getName());
    }

    public void assignTeacher(String email, String lessonId) {
        System.out.println("Teacher with email: " + email + " assigned to lesson ID: " + lessonId);
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

    public Student viewStudent(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                System.out.println("Found student: " + student);
                return student;
            }
        }
        System.out.println("No student found with email: " + email);
        return null;
    }

    public Teacher viewTeacher(String email) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmail().equals(email)) {
                System.out.println("Found teacher: " + teacher);
                return teacher;
            }
        }
        System.out.println("No teacher found with email: " + email);
        return null;
    }

    public List<Course> viewCourses() {
        return courses;
    }
}
