package Models;

import java.util.List;

public class DiplomaProject {
    private String title;
    private List<ResearchPaper> associatedPapers;

    public DiplomaProject(String title, List<ResearchPaper> associatedPapers) {
        this.title = title;
        this.associatedPapers = associatedPapers;
    }

    public String getTitle() {
        return title;
    }

    public List<ResearchPaper> getAssociatedPapers() {
        return associatedPapers;
    }

    public void addResearchPaper(ResearchPaper paper) {
        associatedPapers.add(paper);
    }
}
