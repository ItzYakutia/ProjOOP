package Models;

import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private int credits;
    private List<Teacher> instructors;

    public Course(String courseName, String courseCode, int credits, List<Teacher> instructors) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Course{" + "courseName='" + courseName + '\'' + ", courseCode='" + courseCode + '\'' +
               ", credits=" + credits + ", instructors=" + instructors + '}';
    }
}
