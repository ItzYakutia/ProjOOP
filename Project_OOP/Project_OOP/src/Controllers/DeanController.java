package Controllers;

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
        } catch (InsufficientFundsException e) {
            deanView.displayMessage(e.getMessage());
        }
    }

    public void reviewCourseProposals(List<Course> proposals) {
        dean.reviewCourseProposals(proposals);
        deanView.displayCourseProposals(proposals);
    }
}
