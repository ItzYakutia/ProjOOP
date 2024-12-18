package Models;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends User {

    private double gpa; // Средний балл
    private int year; // Год обучения
    private int credits; // Общее количество кредитов
    private List<Course> courses; // Список курсов, на которые записан студент
    private Map<Course, Mark> transcript; // Транскрипт с оценками по курсам

    public Student(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   double gpa, int year, int credits, List<Course> courses, Map<Course, Mark> transcript) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.gpa = gpa;
        this.year = year;
        this.credits = credits;
        this.courses = courses;
        this.transcript = transcript;
    }

    // Геттеры и сеттеры
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
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Map<Course, Mark> getTranscript() {
        return transcript;
    }

    public void setTranscript(Map<Course, Mark> transcript) {
        this.transcript = transcript;
    }

    // Реализация equals для сравнения студентов по userId
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
                '}';
    }
}

    }
}
