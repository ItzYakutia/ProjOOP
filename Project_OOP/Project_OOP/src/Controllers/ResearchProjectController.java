package Controllers;

public class ResearchProjectController {
    private ResearchProject project;
    private ResearchProjectView projectView;

    public ResearchProjectController(ResearchProject project, ResearchProjectView projectView) {
        this.project = project;
        this.projectView = projectView;
    }

    public void addParticipant(Researcher researcher) {
        try {
            project.addParticipant(researcher);
        } catch (InvalidParticipantException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayProject() {
        projectView.displayProjectDetails(project.getTopic(), project.getParticipants());
    }
}
