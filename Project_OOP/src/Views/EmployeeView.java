package Views;

import Models.Researcher;

public class EmployeeView {
    public void displayResearcherProfileCreated(Researcher researcher) {
        System.out.println("Researcher profile created for Employee: " + researcher.getNameFirst() + " " + researcher.getNameLast());
    }

    public void displayResearcherAssignmentError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
