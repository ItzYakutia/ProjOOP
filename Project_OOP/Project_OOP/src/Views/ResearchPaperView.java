import java.util.List;

public class ResearchPaperView {
    public void displayResearchPapers(List<ResearchPaper> papers) {
        System.out.println("Research Papers:");
        for (ResearchPaper paper : papers) {
            System.out.println("- " + paper.getTitle() + " (" + paper.getCitations() + " citations)");
        }
    }
}
