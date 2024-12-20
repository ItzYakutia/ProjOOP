package Controllers;

import Models.ResearchPaper;
import Models.ResearchProject;
import java.util.List;

public class ResearcherController {
    private List<ResearchProject> projects;

    public ResearcherController(List<ResearchProject> projects) {
        this.projects = projects;
    }

    public void addResearchProject(ResearchProject project) {
        projects.add(project);
        System.out.println("Research Project added: " + project.getTopic());
    }

    public void listResearchProjects() {
        System.out.println("Listing all research projects:");
        for (ResearchProject project : projects) {
            System.out.println(project);
        }
    }
}
