package Views;

public class DeanView {
    public void displayApprovalMessage(String courseName) {
        System.out.println("The course \"" + courseName + "\" has been approved.");
    }

    public void displayTeacherAssignment(String teacherName, String courseName) {
        System.out.println("Teacher \"" + teacherName + "\" has been assigned to the course \"" + courseName + "\".");
    }

    public void displayResearchProjectReview(String projectTitle, boolean approved) {
        String status = approved ? "approved" : "rejected";
        System.out.println("The research project \"" + projectTitle + "\" has been " + status + ".");
    }

    public void displayDepartmentManagement(String departmentName, boolean activate) {
        String status = activate ? "activated" : "deactivated";
        System.out.println("The department \"" + departmentName + "\" has been " + status + ".");
    }

    public void displayDocumentSign(String documentName) {
        System.out.println("The document \"" + documentName + "\" has been signed.");
    }
}
