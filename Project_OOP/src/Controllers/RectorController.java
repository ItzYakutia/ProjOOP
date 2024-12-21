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
}
