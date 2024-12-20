package Controllers;

import Models.*;
import Views.DeanView;
import java.util.List;

public class DeanController {
    private Dean dean;
    private DeanView deanView;

    public DeanController(Dean dean, DeanView deanView) {
        this.dean = dean;
        this.deanView = deanView;
    }

    public void displayMenu() {
        deanView.displayMenu(dean);
    }

    public void manageFaculty() {
        deanView.manageFaculty(dean);
    }

    public void approveFunding() {
        deanView.approveFunding(dean);
    }

    public void reviewCourseProposals() {
        deanView.reviewCourseProposals(dean);
    }

    public void assignTeacherToCourse() {
        deanView.assignTeacherToCourse(dean);
    }

    public void signDocument() {
        deanView.signDocument(dean);
    }

    public void viewStudentPerformance() {
        deanView.viewStudentPerformance(dean);
    }
}
