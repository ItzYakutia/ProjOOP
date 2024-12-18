package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Employee {

    private Title title; // Звание преподавателя (например, Lecturer, Professor)
    private List<Course> courses; // Список курсов, которые ведёт преподаватель
    private List<String> complaints; // Жалобы на студентов, отправленные декану

    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   int workingYears, Title title, List<Course> courses, List<String> complaints) {
        super(username, password, userId, nameFirst, nameLast, email, workingYears);
        this.title = title;
        this.courses = courses != null ? courses : new ArrayList<>();
        this.complaints = complaints != null ? complaints : new ArrayList<>();
    }

    // Геттеры и сеттеры
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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

    public List<String> getComplaints() {
        return complaints;
    }

    public void addComplaint(String complaint) {
        complaints.add(complaint);
    }

    // Реализация equals для сравнения преподавателей по userId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return getUserId().equals(teacher.getUserId());
    }

    // Реализация hashCode для использования в хэш-таблицах
    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    // Реализация toString для удобного вывода информации о преподавателе
    @Override
    public String toString() {
        return "Teacher{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", title=" + title +
                ", workingYears=" + getWorkingYears() +
                ", courses=" + courses.size() +
                ", complaints=" + complaints.size() +
                '}';
    }
}
