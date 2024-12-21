package Views;

import Models.DiplomaProject;
import Models.ResearchPaper;

public class DiplomaProjectView {
    public void displayDiplomaDetails(DiplomaProject project) {
        System.out.println("Diploma Project: " + project.getTitle());
        System.out.println("Associated Papers:");
        for (ResearchPaper paper : project.getAssociatedPapers()) {
            System.out.println("- " + paper.getTitle());
        }
    }
}
