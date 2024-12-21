package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Employee {

    private Title title; // Звание преподавателя
    private List<Course> courses; // Список курсов, которые ведёт преподаватель
    private List<String> complaints; // Жалобы на студентов
    private List<Message> messages; // Список сообщений, отправленных и полученных

    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   int workingYears, Title title) {
        super(username, password, userId, nameFirst, nameLast, email, workingYears);
        this.title = title;
        this.courses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.messages = new ArrayList<>();
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
        if (!courses.contains(course)) {
            courses.add(course);
        } else {
            throw new IllegalArgumentException("Course already assigned to this teacher.");
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            throw new IllegalArgumentException("Course not found in the teacher's list.");
        }
    }

    public List<String> getComplaints() {
        return complaints;
    }

    public void addComplaint(String complaint) {
        complaints.add(complaint);
    }

    public List<Message> getMessages() {
        return messages;
    }

    // Отправка жалобы
    public void sendComplaint(Student student, Course course, String text, UrgencyLevel urgency) {
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("Teacher is not assigned to this course.");
        }
        String complaint = "Complaint about student: " + student.getNameFirst() + " " + student.getNameLast() +
                ", Course: " + course.getName() +
                ", Urgency: " + urgency +
                ", Text: " + text;
        complaints.add(complaint);
    }

    // Отправка сообщения другому сотруднику
    public void sendMessage(Employee recipient, String text) {
        Message message = new Message(this, recipient, text);
        messages.add(message);
        recipient.receiveMessage(message);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Notification for teacher " + getNameFirst() + " " + getNameLast() + ": " + message);
    }

    // Реализация equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return getUserId().equals(teacher.getUserId());
    }

    // Реализация hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", title=" + title +
                ", workingYears=" + getWorkingYears() +
                ", courses=" + courses.size() +
                ", complaints=" + complaints.size() +
                ", messages=" + messages.size() +
                '}';
    }
}
