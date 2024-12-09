import java.util.List;
import java.util.Objects;

public class Rector extends Employee {
    private double universityBudget;
    private List<ResearchProject> overseenProjects;
    private List<String> universityIssues;

    public Rector(String name, String id, double universityBudget) {
        super(name, id);
        this.universityBudget = universityBudget;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }

    public void setUniversityBudget(double universityBudget) {
        this.universityBudget = universityBudget;
    }

    public List<ResearchProject> getOverseenProjects() {
        return overseenProjects;
    }

    public void setOverseenProjects(List<ResearchProject> overseenProjects) {
        this.overseenProjects = overseenProjects;
    }

    public List<String> getUniversityIssues() {
        return universityIssues;
    }

    public void setUniversityIssues(List<String> universityIssues) {
        this.universityIssues = universityIssues;
    }

    public void manageUniversityBudget(double amount) {
        if (amount < 0) {
            System.out.println("Error: Budget cannot be negative!");
        } else {
            this.universityBudget += amount;
            System.out.println("University budget updated. New budget: $" + universityBudget);
        }
    }

    public void overseeResearchProjects(List<ResearchProject> projects) {
        this.overseenProjects = projects;
        System.out.println("Overseeing the following research projects:");
        projects.forEach(project -> System.out.println("- " + project.getTopic()));
    }

    public void addressUniversityIssues(String issue, String resolution) {
        if (universityIssues != null) {
            universityIssues.remove(issue);
            System.out.println("Issue addressed: " + issue + ". Resolution: " + resolution);
        } else {
            System.out.println("No such issue found: " + issue);
        }
    }

    public void signDocument(String documentId) {
        System.out.println("Document signed by Rector. Document ID: " + documentId);
    }

    @Override
    public String toString() {
        return "Rector{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", universityBudget=" + universityBudget +
                ", overseenProjects=" + (overseenProjects != null ? overseenProjects.size() : 0) +
                ", universityIssues=" + (universityIssues != null ? universityIssues.size() : 0) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rector)) return false;
        Rector rector = (Rector) o;
        return Double.compare(rector.universityBudget, universityBudget) == 0 &&
                Objects.equals(getId(), rector.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), universityBudget);
    }
}
