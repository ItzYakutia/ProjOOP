package Controllers;

import Models.ResearchPaper;
import Models.Format;
import Views.ResearchPaperView;

public class ResearchPaperController {
    private ResearchPaper researchPaper;
    private ResearchPaperView researchPaperView;

    public ResearchPaperController(ResearchPaper researchPaper, ResearchPaperView researchPaperView) {
        this.researchPaper = researchPaper;
        this.researchPaperView = researchPaperView;
    }

    public void showPaperDetails() {
        researchPaperView.displayPaperDetails(researchPaper);
    }

    public void showCitation(Format format) {
        String citation = researchPaper.getCitation(format);
        researchPaperView.displayCitation(citation);
    }
}
