import java.util.List;

public class DeanView {
    public void displayFacultyManagementOptions(List<String> departments) {
        System.out.println("Faculty Management Options:");
        departments.forEach(department -> System.out.println("- " + department));
    }

    public void displayFundingApproval(String researchId, double amount) {
        System.out.println("Funding approved for Research ID: " + researchId + " with amount: $" + amount);
    }

    public void displayCourseProposals(List<Course> proposals) {
        System.out.println("Course Proposals:");
        proposals.forEach(proposal -> System.out.println("- " + proposal.getName()));
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
