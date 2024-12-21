package Models;

import Models.Teacher;

public class Dean extends Employee {
    private static Dean instance;
    private String faculty;

    private Dean(String username, String userId, String firstName, String lastName, String email, String faculty) {
        super(username, userId, firstName, lastName, email);
        this.faculty = faculty;
    }

    public static Dean getInstance(String username, String userId, String firstName, String lastName, String email, String faculty) {
        if (instance == null) {
            instance = new Dean(username, userId, firstName, lastName, email, faculty);
        }
        return instance;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void approveCourse(String courseName) {
        System.out.println("Dean " + getFirstName() + " approved the course: " + courseName);
    }

    public void assignTeacher(String courseName, Teacher teacher) {
        System.out.println("Dean " + getFirstName() + " assigned " + teacher.getFirstName() + " to course: " + courseName);
    }

    public boolean reviewResearchProject(String projectTitle) {
        System.out.println("Dean " + getFirstName() + " is reviewing the project: " + projectTitle);
        return true;
    }
}
