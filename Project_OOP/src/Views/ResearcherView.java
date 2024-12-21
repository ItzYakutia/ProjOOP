package Views;

import Models.ResearchPaper;
import Models.ResearchProject;

import java.util.List;

public class ResearcherView {
    public void displayResearchPapers(List<ResearchPaper> papers) {
        System.out.println("Research Papers:");
        for (ResearchPaper paper : papers) {
            System.out.println("- " + paper);
        }
    }

    public void displayHIndex(int hIndex) {
        System.out.println("Researcher's H-index: " + hIndex);
    }

    public void displayProjects(List<ResearchProject> projects) {
        System.out.println("Research Projects:");
        for (ResearchProject project : projects) {
            System.out.println("- " + project.getTopic());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
