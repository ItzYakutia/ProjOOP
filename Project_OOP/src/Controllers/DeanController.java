package Controllers;

import Models.Dean;
import Models.Teacher;
import Views.DeanView;

public class DeanController {
    private Dean dean;
    private DeanView deanView;

    public DeanController(Dean dean, DeanView deanView) {
        this.dean = dean;
        this.deanView = deanView;
    }

    public void approveCourse(String courseName) {
        dean.approveCourse(courseName);
        deanView.displayApprovalMessage(courseName);
    }

    public void assignTeacher(String courseName, Teacher teacher) {
        dean.assignTeacher(courseName, teacher);
        deanView.displayTeacherAssignment(teacher.getNameFirst(), courseName);
    }

    public void reviewResearchProject(String projectTitle) {
        boolean approved = dean.reviewResearchProject(projectTitle);
        deanView.displayResearchProjectReview(projectTitle, approved);
    }

    public void manageDepartment(String departmentName, boolean activate) {
        dean.manageDepartment(departmentName, activate);
        deanView.displayDepartmentManagement(departmentName, activate);
    }

    public void signDocument(String documentName) {
        dean.signDocument(documentName);
        deanView.displayDocumentSign(documentName);
    }
}
