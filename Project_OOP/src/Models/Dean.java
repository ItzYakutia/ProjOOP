package Models;

import java.util.List;
import java.util.Objects;
import javax.naming.InsufficientResourcesException;

public class Dean extends Employee {
    private String facultyName;
    private List<String> managedDepartments;

    // Singleton
    private static Dean instance;

    private Dean(String username, String password, String userId, String nameFirst, String nameLast, String email,
                 List<String> managedDepartments, String facultyName) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.facultyName = facultyName;
        this.managedDepartments = managedDepartments;
    }

    public static Dean getInstance(String username, String password, String userId, String nameFirst, String nameLast,
                                   String email, List<String> managedDepartments, String facultyName) {
        if (instance == null) {
            instance = new Dean(username, password, userId, nameFirst, nameLast, email, managedDepartments, facultyName);
        }
        return instance;
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
        System.out.println((action ? "Activating" : "Deactivating") + " department: " + department);
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

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        System.out.println("Assigned " + teacher.getNameFirst() + " to course: " + course.getName());
    }

    public void signDocument(String document) {
        System.out.println("Document signed by Dean: " + document);
    }

    public void viewStudentPerformance(List<Student> students) {
        System.out.println("=== Viewing Student Performance ===");
        for (Student student : students) {
            System.out.println(student.getNameFirst() + " " + student.getNameLast() + " - GPA: " + student.getGpa());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dean dean = (Dean) obj;
        return Objects.equals(facultyName, dean.facultyName) &&
               Objects.equals(managedDepartments, dean.managedDepartments) &&
               super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, managedDepartments, super.hashCode());
    }

    @Override
    public String toString() {
        return "Dean{" +
               "facultyName='" + facultyName + '\'' +
               ", managedDepartments=" + managedDepartments +
               ", " + super.toString() +
               '}';
    }
}
