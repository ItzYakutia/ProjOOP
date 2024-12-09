package Models;

import java.util.List;
import java.util.Map;

public class Student extends User {

    private double gpa;
    private int yearOfStudy;
    private int credits;
    private List<Course> courses;
    private Map<Course, Mark> transcript;
    private String studentOrganization;

    public Student(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   double gpa, int yearOfStudy, int credits, List<Course> courses, Map<Course, Mark> transcript,
                   String studentOrganization) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.gpa = gpa;
        this.yearOfStudy = yearOfStudy;
        setCredits(credits); // Apply validation for credits
        this.courses = courses;
        this.transcript = transcript;
        checkFailingGrades(); // Check failing grades upon initialization
        this.studentOrganization = studentOrganization;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        if (yearOfStudy < 1 || yearOfStudy > 4) {
            throw new IllegalArgumentException("Year of study must be between 1 and 4");
        }
        this.yearOfStudy = yearOfStudy;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 0 || credits > 21) {
            throw new IllegalArgumentException("Credits must not exceed 21");
        }
        this.credits = credits;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Map<Course, Mark> getTranscript() {
        return transcript;
    }

    public void setTranscript(Map<Course, Mark> transcript) {
        this.transcript = transcript;
        checkFailingGrades(); // Re-check failing grades after updating transcript
    }

    public String getStudentOrganization() {
        return studentOrganization;
    }

    public void setStudentOrganization(String studentOrganization) {
        this.studentOrganization = studentOrganization;
    }

    private void checkFailingGrades() {
        long failCount = transcript.values().stream().filter(mark -> mark.isFailing()).count();
        if (failCount > 3) {
            throw new IllegalStateException("Students cannot fail more than 3 times");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + getUsername() + '\'' +
                ", userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", gpa=" + gpa +
                ", yearOfStudy=" + yearOfStudy +
                ", credits=" + credits +
                ", courses=" + courses +
                ", transcript=" + transcript +
                ", studentOrganization='" + studentOrganization + '\'' +
                '}';
    }
}
