import java.util.List;

public class ResearcherController {
    private Researcher researcher;
    private ResearcherView researcherView;

    public ResearcherController(Researcher researcher, ResearcherView researcherView) {
        this.researcher = researcher;
        this.researcherView = researcherView;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researcher.addResearchPaper(paper);
        System.out.println("Research paper added: " + paper.getTitle());
    }

    public void calculateHIndex() {
        int hIndex = 0;
        List<ResearchPaper> papers = researcher.getResearchPapers();
        for (int i = 0; i < papers.size(); i++) {
            if (papers.get(i).getCitations() >= i + 1) {
                hIndex++;
            }
        }
        researcherView.displayHIndex(hIndex);
    }
}
