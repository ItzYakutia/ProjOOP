package Models;

import Models.Teacher;

public class Dean extends Employee {
    private School school;

    public Dean(String username, String userId, String firstName, String lastName, String email, School school, String password) {
        super(username, userId, firstName, lastName, email, password);
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void approveCourse(String courseName) {
        System.out.println("Dean " + getNameFirst() + " approved the course: " + courseName);
    }

    public void assignTeacher(String courseName, Teacher teacher) {
        System.out.println("Dean " + getNameFirst() + " assigned " + teacher.getNameFirst() + " to course: " + courseName);
    }

    public boolean reviewResearchProject(String projectTitle) {
        System.out.println("Dean " + getNameFirst() + " is reviewing the project: " + projectTitle);
        return true;
    }

    public void manageDepartment(String departmentName, boolean activate) {
        if (activate) {
            System.out.println("Dean " + getNameFirst() + " activated the department: " + departmentName);
        } else {
            System.out.println("Dean " + getNameFirst() + " deactivated the department: " + departmentName);
        }
    }

    public void signDocument(String documentName) {
        System.out.println("Dean " + getNameFirst() + " signed the document: " + documentName);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Dean " + getNameFirst() + " received notification: " + message);
    }
}
