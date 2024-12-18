package Controllers;

import Models.*;

import java.util.List;
import java.util.stream.Collectors;

public class StudentController {

    private List<Student> students;
    private List<Course> courses;
    private List<News> news;

    public StudentController(List<Student> students, List<Course> courses, List<News> news) {
        this.students = students;
        this.courses = courses;
        this.news = news;
    }

    // Добавление нового студента с проверкой уникальности
    public void addStudent(Student newStudent) {
        if (students.stream().anyMatch(student -> student.equals(newStudent))) {
            System.out.println("Error: Student already exists.");
            return;
        }
        students.add(newStudent);
        System.out.println("Student added successfully: " + newStudent.getNameFirst() + " " + newStudent.getNameLast());
    }

    // Удаление студента
    public void removeStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(student);
        System.out.println("Student removed: " + student.getNameFirst() + " " + student.getNameLast());
    }

    // Просмотр всех доступных курсов
    public List<Course> viewCourses() {
        return courses;
    }

    // Регистрация студента на курс
    public void registerForCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);
        if (student != null && course != null) {
            if (student.getCredits() + course.getCredits() > 21) {
                System.out.println("Error: Student cannot register for more than 21 credits.");
                return;
            }
            student.addCourse(course);
            course.addStudent(student);
            System.out.println("Student registered successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    // Просмотр оценок студента по курсу
    public List<Mark> viewMarks(String courseName, String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return null;
        }
        return student.getTranscript().entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(courseName))
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    // Просмотр транскрипта студента
    public void viewTranscript(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (student.getTranscript() == null || student.getTranscript().isEmpty()) {
            System.out.println("Transcript is empty. No marks are available for this student.");
            return;
        }
        System.out.println("Transcript for student: " + student.getNameFirst() + " " + student.getNameLast());
        student.getTranscript().forEach((course, mark) -> {
            System.out.println("Course: " + course.getName() + ", Mark: " + mark.getTotal());
        });
    }

    // Оценка курса студентом
    public void rateCourse(String courseId, int rating, String feedback) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }
        System.out.println("Course " + course.getName() + " rated with " + rating + " stars. Feedback: " + feedback);
    }

    // Запрос на вступление в организацию
    public void requestToJoinOrganization(String orgName, String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Request from student " + student.getNameFirst() + " to join organization: " + orgName);
    }

    // Запрос информации о курсе
    public String requestCourseInfo(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            return "Course not found.";
        }
        return "Course: " + course.getName() + ", Description: " + course.getDescription();
    }

    // Просмотр новостей для студента
    public List<News> viewNews(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return null;
        }
        return news;
    }

    // Вспомогательные методы для поиска студента и курса
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
