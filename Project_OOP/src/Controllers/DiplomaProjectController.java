package Controllers;

import Models.DiplomaProject;
import Models.ResearchPaper;
import Views.DiplomaProjectView;

public class DiplomaProjectController {
    private DiplomaProject project;
    private DiplomaProjectView view;

    public DiplomaProjectController(DiplomaProject project, DiplomaProjectView view) {
        this.project = project;
        this.view = view;
    }

    public void showDiplomaDetails() {
        view.displayDiplomaDetails(project);
    }

    public void addResearchPaper(ResearchPaper paper) {
        project.addResearchPaper(paper);
        view.displayDiplomaDetails(project);
    }
}
