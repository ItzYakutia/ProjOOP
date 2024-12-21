package Controllers;

import Models.ResearchPaper;
import Models.ResearchProject;
import Models.Researcher;
import Views.ResearcherView;

import java.util.Comparator;

public class ResearcherController {
    private Researcher researcher;
    private ResearcherView researcherView;

    public ResearcherController(Researcher researcher, ResearcherView researcherView) {
        this.researcher = researcher;
        this.researcherView = researcherView;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researcher.addResearchPaper(paper);
        researcherView.displayMessage("Added a new research paper: " + paper.getTitle());
    }

    public void addResearchProject(ResearchProject project) {
        researcher.addResearchProject(project);
        researcherView.displayMessage("Joined the research project: " + project.getTopic());
    }

    public void printPapers(Comparator<ResearchPaper> comparator) {
        researcher.printPapers(comparator);
        researcherView.displayResearchPapers(researcher.getResearchPapers());
    }

    public void calculateHIndex() {
        int hIndex = researcher.calculateHIndex();
        researcherView.displayHIndex(hIndex);
    }
}
