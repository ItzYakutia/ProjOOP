import java.util.List;
import java.util.Objects;

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

    public void manageFaculty(String facultyName, boolean action) {
        System.out.println("Managing faculty: " + facultyName + ", action: " + (action ? "Activate" : "Deactivate"));
    }

    public void approveResearchFunding(String researchId, double amount) {
        System.out.println("Approved research funding for research ID: " + researchId + " with amount: $" + amount);
    }

    public void reviewCourseProposals(List<Course> proposals) {
        System.out.println("Reviewing course proposals:");
        proposals.forEach(proposal -> System.out.println("- " + proposal.getName()));
    }

    public void viewStudentGrades(String studentId) {
        System.out.println("Viewing grades for student ID: " + studentId);
    }

    public void signDocument(String documentId) {
        System.out.println("Document " + documentId + " signed by the Dean.");
    }

    @Override
    public String toString() {
        return "Dean{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", managedDepartments=" + managedDepartments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dean)) return false;
        Dean dean = (Dean) o;
        return Objects.equals(getId(), dean.getId()) &&
                Objects.equals(facultyName, dean.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), facultyName);
    }
}
