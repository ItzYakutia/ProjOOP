package Controllers;

import Models.Rector;
import Views.RectorView;

public class RectorController {
    private Rector rector;
    private RectorView rectorView;

    public RectorController(Rector rector, RectorView rectorView) {
        this.rector = rector;
        this.rectorView = rectorView;
    }

    public void manageBudget() {
        rectorView.manageBudget(rector);
    }

    public void approveProgram() {
        rectorView.approveProgram(rector);
    }

    public void revokeProgram() {
        rectorView.revokeProgram(rector);
    }

    public void appointDean() {
        rectorView.appointDean(rector);
    }

    public void overseeResearchProjects() {
        rectorView.overseeResearchProjects(rector);
    }

    public void addressUniversityIssues() {
        rectorView.addressUniversityIssues(rector);
    }

    public void signDocument() {
        rectorView.signDocument(rector);
    }

    public void displayMenu() {
        rectorView.displayMenu(rector);
    }
}
