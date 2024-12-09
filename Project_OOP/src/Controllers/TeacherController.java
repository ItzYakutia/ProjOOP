package Controllers;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherController {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Lesson> lessons;
    private List<Course> courses;

    public TeacherController(List<Teacher> teachers, List<Student> students, List<Lesson> lessons, List<Course> courses) {
        this.teachers = teachers;
        this.students = students;
        this.lessons = lessons;
        this.courses = courses;
    }

    /**
     * Установить оценку студенту за урок.
     */
    public void setMark(String studentId, int mark, String lessonId) {
        Student student = findStudentById(studentId);
        Lesson lesson = findLessonById(lessonId);

        if (student == null || lesson == null) {
            System.out.println("Error: Student or lesson not found.");
            return;
        }

        Mark studentMark = new Mark(student, lesson.getCourse(), mark, 0, 0);
        student.getTranscript().put(lesson.getCourse(), studentMark);
        System.out.println("Mark set successfully for student " + student.getNameFirst() + ".");
    }

    /**
     * Отметить посещаемость студента.
     */
    public void makeAttendance(String studentId, String lessonId, int att) {
        Student student = findStudentById(studentId);
        Lesson lesson = findLessonById(lessonId);

        if (student == null || lesson == null) {
            System.out.println("Error: Student or lesson not found.");
            return;
        }

        System.out.println("Attendance marked for student " + student.getNameFirst() + " for lesson " + lessonId + ".");
    }

    /**
     * Отправить жалобу на студента.
     */
    public void sentComplaint(String studentId, String lessonId, String text, String urgencyLevel) {
        Student student = findStudentById(studentId);
        Lesson lesson = findLessonById(lessonId);

        if (student == null || lesson == null) {
            System.out.println("Error: Student or lesson not found.");
            return;
        }

        System.out.println("Complaint sent for student " + student.getNameFirst() + ": " + text + " (Urgency: " + urgencyLevel + ")");
    }

    /**
     * Просмотр курса.
     */
    public Course viewCourse(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Error: Course not found.");
        }
        return course;
    }

    /**
     * Просмотр информации о студенте.
     */
    public Student viewStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student not found.");
        }
        return student;
    }

    /**
     * Отправка сообщения сотруднику.
     */
    public void sentMessage(String text, String employeeId) {
        System.out.println("Message to employee " + employeeId + ": " + text);
    }

    /**
     * Просмотр студентов на уроке.
     */
    public List<Student> viewStudents(String lessonId) {
        Lesson lesson = findLessonById(lessonId);
        if (lesson == null) {
            System.out.println("Error: Lesson not found.");
            return new ArrayList<>();
        }

        System.out.println("Students for lesson " + lessonId + ":");
        return lesson.getCourse().getStudents();
    }

    /**
     * Загрузка учебного плана.
     */
    public void loadSyllabus(Syllabus syllabus) {
        System.out.println("Syllabus loaded: " + syllabus.getTitle());
    }

    /**
     * Отправка сообщения.
     */
    public void sentMessage(String text, String recipientId) {
        System.out.println("Message to " + recipientId + ": " + text);
    }

    // Вспомогательные методы
    private Student findStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    private Lesson findLessonById(String lessonId) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId().equals(lessonId))
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
