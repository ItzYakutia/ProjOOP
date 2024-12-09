public class RectorController {
    private Rector rector;
    private RectorView rectorView;

    public RectorController(Rector rector, RectorView rectorView) {
        this.rector = rector;
        this.rectorView = rectorView;
    }

    public void updateBudget(double amount) {
        try {
            rector.manageBudget(amount);
            rectorView.displayUniversityBudget(rector.getUniversityBudget());
        } catch (InsufficientFundsException e) {
            rectorView.displayMessage(e.getMessage());
        }
    }
}
