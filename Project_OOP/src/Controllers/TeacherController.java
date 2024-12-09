package Controllers;

import Models.*;

import java.util.List;

public class TeacherController {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public TeacherController(List<Teacher> teachers, List<Student> students, List<Course> courses) {
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
    }

    /**
     * Добавить жалобу для преподавателя.
     */
    public void sendComplaint(Teacher teacher, String text, UrgencyLevel urgencyLevel) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Complaint text cannot be null or empty.");
        }
        teacher.getComplaints().add(text + " (" + urgencyLevel + ")");
        System.out.println("Complaint added: " + text + " (Urgency: " + urgencyLevel + ")");
    }

    /**
     * Просмотр студентов, зарегистрированных на курс.
     */
    public List<Student> viewStudents(Teacher teacher, String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return null;
        }
        if (!teacher.getCourses().contains(course)) {
            System.out.println("Teacher does not teach this course.");
            return null;
        }
        return course.getStudents();
    }

    /**
     * Просмотр информации о курсе.
     */
    public Course viewCourse(String courseId) {
        return findCourseById(courseId);
    }

    /**
     * Просмотр информации о студенте.
     */
    public Student viewStudent(String studentId) {
        return findStudentById(studentId);
    }

    /**
     * Отправка сообщения сотруднику.
     */
    public void sendMessage(Teacher teacher, String text, String recipientId) {
        System.out.println("Teacher " + teacher.getNameFirst() + " sent message to " + recipientId + ": " + text);
    }

    // Вспомогательные методы
    private Student findStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}

