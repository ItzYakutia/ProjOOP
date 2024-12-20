package Models;

import java.util.List;

import javax.naming.InsufficientResourcesException;

public class Dean extends Employee {
    private String facultyName;

    public Dean(String username, String password, String userId, String nameFirst, String nameLast, String email,
    		String facultyName) {
    		super(username, password, userId, nameFirst, nameLast, email);
    		this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void manageFaculty(String department, boolean action) {
        if (action) {
            System.out.println("Activating department: " + department);
        } else {
            System.out.println("Deactivating department: " + department);
        }
    }

    public void approveResearchFunding(String researchId, double amount) throws InsufficientResourcesException {
        if (amount < 0) {
            throw new InsufficientResourcesException("Cannot allocate negative funding for research ID: " + researchId);
        }
        System.out.println("Approved funding of $" + amount + " for research ID: " + researchId);
    }

    public void reviewCourseProposals(List<Course> proposals) {
        proposals.forEach(proposal -> System.out.println("Reviewing course proposal: " + proposal.getName()));
    }
}

