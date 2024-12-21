package Models;

import java.util.List;
import java.util.Objects;
import javax.naming.InsufficientResourcesException;

public class Rector extends Employee {
    private double universityBudget;
    private List<String> accreditedPrograms;

    public Rector(String username, String password, String userId, String nameFirst, String nameLast, String email, double budget, List<String> accreditedPrograms) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.universityBudget = budget;
        this.accreditedPrograms = accreditedPrograms;
    }

    // Getters and Setters
    public double getUniversityBudget() {
        return universityBudget;
    }

    public void setUniversityBudget(double universityBudget) {
        this.universityBudget = universityBudget;
    }

    public List<String> getAccreditedPrograms() {
        return accreditedPrograms;
    }

    public void setAccreditedPrograms(List<String> accreditedPrograms) {
        this.accreditedPrograms = accreditedPrograms;
    }

    // Budget Management
    public void manageBudget(double amount) throws InsufficientResourcesException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new InsufficientResourcesException("Not enough budget for this operation!");
        }
        universityBudget += amount;
    }

    // Program Management
    public void approveProgram(String program) {
        accreditedPrograms.add(program);
        System.out.println("Program approved: " + program);
    }

    public void revokeProgram(String program) {
        accreditedPrograms.remove(program);
        System.out.println("Program revoked: " + program);
    }

    // Dean Management
    public void appointDean(Dean dean, String faculty) {
        System.out.println("Appointed Dean " + dean.getNameFirst() + " " + dean.getNameLast() + " to faculty: " + faculty);
    }

    // Research Projects
    public void overseeResearchProjects(List<ResearchProject> projects) {
        projects.forEach(project -> System.out.println("Overseeing research project: " + project.getTitle()));
    }

    // Address Issues
    public void addressUniversityIssues(String issue) {
        System.out.println("Resolving university issue: " + issue);
    }

    // Document Signin
    public void signDocument(String document) {
        System.out.println("Document signed by Rector: " + document);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rector rector = (Rector) obj;
        return Double.compare(rector.universityBudget, universityBudget) == 0 &&
               Objects.equals(accreditedPrograms, rector.accreditedPrograms) &&
               super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityBudget, accreditedPrograms, super.hashCode());
    }

    @Override
    public String toString() {
        return "Rector{" +
               "universityBudget=" + universityBudget +
               ", accreditedPrograms=" + accreditedPrograms +
               ", " + super.toString() +
               '}';
    }
}
