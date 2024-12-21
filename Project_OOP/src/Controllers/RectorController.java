package Controllers;

import Models.Rector;
import Models.ResearchPaper;
import Models.Researcher;
import Views.RectorView;

import java.util.Comparator;
import java.util.List;

public class RectorController {
    private Rector rector;
    private RectorView rectorView;

    public RectorController(Rector rector, RectorView rectorView) {
        this.rector = rector;
        this.rectorView = rectorView;
    }

    public void manageBudget(double amount) {
        try {
            rector.manageBudget(amount);
            rectorView.displayBudget(rector.getUniversityBudget());
        } catch (IllegalArgumentException e) {
            rectorView.displayError(e.getMessage());
        }
    }

    public void approveDecision(String decision) {
        rector.approveDeanDecision(decision);
        rectorView.displayApproval(decision);
    }

    public void allocateFunding(String facultyName, double amount) {
        try {
            rector.allocateFunding(facultyName, amount);
            rectorView.displayFundingAllocation(facultyName, amount);
        } catch (IllegalArgumentException e) {
            rectorView.displayError(e.getMessage());
        }
    }

    public void signAgreement(String agreementName) {
        rector.signAgreement(agreementName);
        rectorView.displaySignedAgreement(agreementName);
    }

    public void printAllResearchPapers(List<Researcher> researchers, Comparator<ResearchPaper> comparator) {
        rector.printAllResearchPapers(researchers, comparator);
    }

    public void displayTopCitedResearcherBySchool(List<Researcher> researchers, String schoolName) {
        Researcher researcher = rector.getTopCitedResearcherBySchool(researchers, schoolName);
        rectorView.displayTopCitedResearcher(researcher);
    }

    public void displayTopCitedResearcherOfYear(List<Researcher> researchers, int year) {
        Researcher researcher = rector.getTopCitedResearcherOfYear(researchers, year);
        rectorView.displayTopCitedResearcher(researcher);
    }
}
