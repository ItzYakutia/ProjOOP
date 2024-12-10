package Views;

import java.util.List;

public class ResearcherView {
    public void displayResearchPapers(List<ResearchPaper> papers) {
        System.out.println("Research Papers:");
        for (ResearchPaper paper : papers) {
            System.out.println("- " + paper.getTitle());
        }
    }

    public void displayHIndex(int hIndex) {
        System.out.println("H-Index: " + hIndex);
    }
}
