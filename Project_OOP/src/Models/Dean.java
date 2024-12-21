package Models;

import Models.Teacher;

public class Dean extends Employee {
    private static Dean instance;
    private Faculty faculty;

    private Dean(String username, String userId, String firstName, String lastName, String email, Faculty faculty, String password) {
        super(username, userId, firstName, lastName, email, password);
        this.faculty = faculty;
    }

    public static Dean getInstance(String username, String userId, String firstName, String lastName, String email, Faculty faculty, String password) {
        if (instance == null) {
            instance = new Dean(username, userId, firstName, lastName, email, faculty, password);
        }
        return instance;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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
	}
}
