package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends User {

    private double gpa; // Средний балл
    private int year; // Год обучения
    private int credits; // Общее количество кредитов
    private List<Course> courses; // Список курсов, на которые записан студент
    private Map<Course, Mark> transcript; // Транскрипт с оценками по курсам
    private String major; // Основная специальность студента


    public Student(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   double gpa, int year, int credits, List<Course> courses, Map<Course, Mark> transcript) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.gpa = gpa;
        this.year = year;
        this.credits = credits;
        this.courses = courses != null ? courses : new ArrayList<>();
        this.transcript = transcript;
    }

    // Геттеры и сеттеры
    public String getMajor() {
    return major;
}

public void setMajor(String major) {
    this.major = major;
}
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        // Предотвращаем добавление курса, если студент уже зарегистрирован на него
        if (courses.contains(course)) {
throw new IllegalArgumentException("Student is already registered for the course: " + course.getName());
            return;
        }
        courses.add(course);
        credits += course.getCredits();
    }

    public void removeCourse(Course course) {
        if (!courses.contains(course)) {
    throw new IllegalArgumentException("Student is not registered for the course: " + course.getName());
     }

    }

    public Map<Course, Mark> getTranscript() {
        return transcript;
    }

    public void setTranscript(Map<Course, Mark> transcript) {
        this.transcript = transcript;
    }

    // Реализация equals для проверки уникальности курса в списке курсов студента
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getUserId().equals(student.getUserId());
    }

    // Реализация hashCode для использования в хэш-таблицах
    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    // Реализация toString для удобного вывода информации о студенте
    @Override
    public String toString() {
        return "Student{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", gpa=" + gpa +
                ", year=" + year +
                ", credits=" + credits +
                ", courses=" + courses.size() +
                '}';
    }
}
