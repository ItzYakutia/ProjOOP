package Controllers;

import Models.FinanceOffice;

public class FinanceOfficeController {
    private FinanceOffice financeOffice;

    public FinanceOfficeController(FinanceOffice financeOffice) {
        this.financeOffice = financeOffice;
    }

    public void manageFunds(double amount) {
        System.out.println("Finance office " + financeOffice.getOfficeName() + " managed funds: $" + amount);
    }
}
