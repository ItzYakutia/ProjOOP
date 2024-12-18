package Controllers;

import Models.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentController {

    private List<Student> students;
    private List<Course> courses;
    private List<News> news;
    private List<Teacher> teachers;

    public StudentController(List<Student> students, List<Course> courses, List<News> news, List<Teacher> teachers) {
        this.students = students;
        this.courses = courses;
        this.news = news;
        this.teachers = teachers;
    }

    // Сортировка студентов по имени (алфавитно)
    public List<Student> sortStudentsByName() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getNameFirst).thenComparing(Student::getNameLast))
                .collect(Collectors.toList());
    }

    // Сортировка студентов по GPA (по убыванию)
    public List<Student> sortStudentsByGPA() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
    // Пример использования сортировки для конкретного курса
    public List<Student> sortStudentsInCourseByGPA(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        return course.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
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
                .map(Map.Entry::getValue)
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
        student.getTranscript().forEach((course, mark) -> {
            System.out.println("Course: " + course.getName() + ", Mark: " + mark.getTotal());
        });
    }

    // Новый метод: Просмотр информации о преподавателе для курса
    public void viewTeacherInfo(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        Teacher teacher = teachers.stream()
                .filter(t -> t.getCourses().contains(course))
                .findFirst()
                .orElse(null);

        if (teacher != null) {
            System.out.println("Teacher for course " + course.getName() + ": " +
                    teacher.getNameFirst() + " " + teacher.getNameLast() + " (" + teacher.getTitle() + ")");
        } else {
            System.out.println("No teacher assigned for this course.");
        }
    }

    // Новый метод: Оценка преподавателя
    public void rateTeacher(String teacherId, int rating, String feedback) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }

        // Здесь можно реализовать сохранение рейтинга и отзыва в БД или другом хранилище
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " rated with " + rating + " stars. Feedback: " + feedback);
    }

    // Новый метод: Вступление в организацию
    public void joinOrganization(String orgName, String studentId, boolean isHead) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        // Здесь можно реализовать логику добавления студента в организацию
        if (isHead) {
            System.out.println(student.getNameFirst() + " " + student.getNameLast() +
                    " has joined the organization " + orgName + " as the head.");
        } else {
            System.out.println(student.getNameFirst() + " " + student.getNameLast() +
                    " has joined the organization " + orgName + ".");
        }
    }

    // Новый метод: Проверка количества провалов
    public void checkFailedCourses(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        long failedCourses = student.getTranscript().values().stream()
                .filter(mark -> mark.getTotal() < 50) // Считаем, что менее 50 — это провал
                .count();

        if (failedCourses > 3) {
            System.out.println("Student has failed more than 3 courses. Please take action.");
        } else {
            System.out.println("Student has " + failedCourses + " failed courses.");
        }
    }

    // Вспомогательные методы для поиска студентов, курсов и преподавателей
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

    private Teacher findTeacherById(String teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }
}
