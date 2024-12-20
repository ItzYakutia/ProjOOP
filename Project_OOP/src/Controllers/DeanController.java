package Controllers;

import Models.*;
import Views.DeanView;
import java.util.List;
import javax.naming.InsufficientResourcesException;
import Exceptions.InvalidCourseException;

public class DeanController {
    private Dean dean;
    private DeanView deanView;

    public DeanController(Dean dean, DeanView deanView) {
        this.dean = dean;
        this.deanView = deanView;
    }

    public void manageFaculty(String department, boolean action) {
        dean.manageFaculty(department, action);
        deanView.displayMessage("Faculty " + department + " has been " + (action ? "activated" : "deactivated"));
    }

    public void approveFunding(String researchId, double amount) {
        try {
            dean.approveResearchFunding(researchId, amount);
            deanView.displayFundingApproval(researchId, amount);
        } catch (InsufficientResourcesException e) {
            deanView.displayMessage(e.getMessage());
        }
    }

    public void reviewCourseProposals(List<Course> proposals) {
        try {
            dean.reviewCourseProposals(proposals);
            deanView.displayCourseProposals(proposals);
        } catch (InvalidCourseException e) {
            deanView.displayMessage(e.getMessage());
        }
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        dean.assignTeacherToCourse(teacher, course);
        deanView.displayTeacherAssignment(teacher.getNameFirst(), course.getName());
    }

    public void signDocument(String document) {
        dean.signDocument(document);
        deanView.displayMessage("Document signed: " + document);
    }

    public void viewStudentPerformance(List<Student> students) {
        dean.viewStudentPerformance(students);
        deanView.displayStudentPerformance(students);
    }
}
