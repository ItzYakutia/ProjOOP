import java.util.List;

public class ResearchPaperController {
    private ResearchPaperView researchPaperView;

    public ResearchPaperController(ResearchPaperView researchPaperView) {
        this.researchPaperView = researchPaperView;
    }

    public void displayPapers(List<ResearchPaper> papers) {
        researchPaperView.displayResearchPapers(papers);
    }
}
