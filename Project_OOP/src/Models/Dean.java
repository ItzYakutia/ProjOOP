package Models;

import java.util.List;

public class Dean extends Employee {
    private String facultyName;
    private List<String> managedDepartments;

    public Dean(String name, String id, String facultyName, List<String> managedDepartments) {
        super(name, id);
        this.facultyName = facultyName;
        this.managedDepartments = managedDepartments;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<String> getManagedDepartments() {
        return managedDepartments;
    }

    public void setManagedDepartments(List<String> managedDepartments) {
        this.managedDepartments = managedDepartments;
    }

    public void manageFaculty(String department, boolean action) {
        if (action) {
            System.out.println("Activating department: " + department);
        } else {
            System.out.println("Deactivating department: " + department);
        }
    }

    public void approveResearchFunding(String researchId, double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new InsufficientFundsException("Cannot allocate negative funding for research ID: " + researchId);
        }
        System.out.println("Approved funding of $" + amount + " for research ID: " + researchId);
    }

    public void reviewCourseProposals(List<Course> proposals) {
        proposals.forEach(proposal -> System.out.println("Reviewing course proposal: " + proposal.getName()));
    }
}

