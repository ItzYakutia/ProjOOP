package Views;

import Models.ResearchPaper;
import Models.ResearchProject;
import Models.Researcher;

public class ResearchProjectView {

    public void displayProjectDetails(ResearchProject project) {
        System.out.println("Research Project Details:");
        System.out.println("Topic: " + project.getTopic());
        System.out.println("Supervisor: " + project.getSupervisor().getNameFirst() + " " + project.getSupervisor().getNameLast());
        System.out.println("Participants:");
        for (Researcher participant : project.getParticipants()) {
            System.out.println("- " + participant.getNameFirst() + " " + participant.getNameLast());
        }
        System.out.println("Published Papers:");
        for (ResearchPaper paper : project.getPublishedPapers()) {
            System.out.println("- " + paper.getTitle());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayDiplomaApproval(String projectTitle, Researcher researcher) {
        System.out.println("Diploma project \"" + projectTitle + "\" approved for Researcher: " + researcher.getNameFirst() + " " + researcher.getNameLast());
    }
}
