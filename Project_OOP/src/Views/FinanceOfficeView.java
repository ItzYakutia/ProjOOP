package Views;

import Models.*;

public class FinanceOfficeView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAllocationConfirmation(boolean success) {
        if (success) {
            System.out.println("Funds allocated successfully.");
        } else {
            System.out.println("Failed to allocate funds.");
        }
    }

    public void displayProfile(FinanceOffice office) {
        System.out.println("Finance Office Profile:\n" + office);
    }
}
