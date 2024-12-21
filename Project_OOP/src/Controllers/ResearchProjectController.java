package Controllers;

import Models.ResearchPaper;
import Models.ResearchProject;
import Models.Researcher;
import Views.ResearchProjectView;

public class ResearchProjectController {
    private ResearchProject project;
    private ResearchProjectView view;

    public ResearchProjectController(ResearchProject project, ResearchProjectView view) {
        this.project = project;
        this.view = view;
    }

    public void showProjectDetails() {
        view.displayProjectDetails(project);
    }

    public void addResearchPaper(ResearchPaper paper) {
        project.addResearchPaper(paper);
        view.displayMessage("Research paper added to the project: " + paper.getTitle());
    }

    public void addParticipant(Researcher researcher) {
        try {
            project.addParticipant(researcher);
            view.displayMessage("Participant added to the project: " + researcher.getNameFirst());
        } catch (IllegalArgumentException e) {
            view.displayMessage(e.getMessage());
        }
    }

    public void approveDiplomaProject(String projectTitle, Researcher researcher) {
        try {
            project.approveDiplomaProject(projectTitle, researcher);
            view.displayDiplomaApproval(projectTitle, researcher);
        } catch (IllegalArgumentException e) {
            view.displayMessage(e.getMessage());
        }
    }
}
