package Models;

import java.util.List;

public class Teacher extends Employee {

    private String title; // Звание преподавателя (например, Professor, Lecturer)
    private List<Course> courses; // Список курсов, которые ведёт преподаватель
    private List<Message> complaints; // Список жалоб на студентов или другие вопросы

    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   int workingYears, String title, List<Course> courses, List<Message> complaints) {
        super(username, password);
        this.workingYears = workingYears;
        this.title = title;
        this.courses = courses;
        this.complaints = complaints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Message> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Message> complaints) {
        this.complaints = complaints;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "username='" + getUsername() + '\'' +
                ", userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", workingYears=" + workingYears +
                ", title='" + title + '\'' +
                ", courses=" + courses +
                ", complaints=" + complaints +
                '}';
    }
}
