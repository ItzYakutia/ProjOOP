package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Employee {

    private Title title;
    private List<Course> courses;
    private List<String> complaints;

    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   int workingYears, Title title, List<Course> courses, List<String> complaints) {
        super(username, password, userId, nameFirst, nameLast, email, workingYears);
        this.title = title;
        this.courses = courses != null ? courses : new ArrayList<>();
        this.complaints = complaints != null ? complaints : new ArrayList<>();
    }

    // Business Logic in the Model Layer
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            throw new IllegalArgumentException("Error: Course not found.");
        }
    }

    public void addComplaint(String complaint) {
        complaints.add(complaint);
    }

    public void assignMark(Student student, Course course, double attestation1, double attestation2, double finalExam) {
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("Teacher is not assigned to this course.");
        }

        if (attestation1 < 0 || attestation1 > 100 || attestation2 < 0 || attestation2 > 100 || finalExam < 0 || finalExam > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        Mark mark = student.getTranscript().get(course);
        if (mark == null) {
            mark = new Mark(student, course, attestation1, attestation2, finalExam);
            student.getTranscript().put(course, mark);
        } else {
            mark.setAttestation1(attestation1);
            mark.setAttestation2(attestation2);
            mark.setFinalExam(finalExam);
            mark.setTotal(attestation1 + attestation2 + finalExam);
        }
    }

    // Utility Methods for Queries
    public boolean isAssignedToCourse(Course course) {
        return courses.contains(course);
    }

    // Getters and Setters
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<String> getComplaints() {
        return complaints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return getUserId().equals(teacher.getUserId());
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
                '}';
    }
}
