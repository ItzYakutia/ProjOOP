package Views;

import Models.ResearchPaper;
import Models.Researcher;

public class RectorView {
    public void displayBudget(double budget) {
        System.out.println("Current University Budget: " + budget);
    }

    public void displayApproval(String decision) {
        System.out.println("Decision approved: " + decision);
    }

    public void displayFundingAllocation(String facultyName, double amount) {
        System.out.println("Funding of " + amount + " allocated to faculty: " + facultyName);
    }

    public void displaySignedAgreement(String agreementName) {
        System.out.println("Agreement signed: " + agreementName);
    }

    public void displayResearchPaper(ResearchPaper paper) {
        System.out.println(paper.toString());
    }

    public void displayTopCitedResearcher(Researcher researcher) {
        if (researcher != null) {
            System.out.println("Top Cited Researcher: " + researcher.getNameFirst() + " " + researcher.getNameLast());
        } else {
            System.out.println("No top researcher found.");
        }
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
