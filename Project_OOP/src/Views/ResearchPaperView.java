package Views;

import Models.ResearchPaper;
import Models.Format;

public class ResearchPaperView {

    public void displayPaperDetails(ResearchPaper paper) {
        System.out.println("Research Paper Details:");
        System.out.println("- Title: " + paper.getTitle());
        System.out.println("- Authors: " + String.join(", ", paper.getAuthors()));
        System.out.println("- Journal: " + paper.getJournal());
        System.out.println("- Date: " + paper.getDate());
        System.out.println("- Citations: " + paper.getCitations());
        System.out.println("- Pages: " + paper.getPages());
        System.out.println("- DOI: " + paper.getDoi());
    }

    public void displayCitation(String citation) {
        System.out.println("Citation:");
        System.out.println(citation);
    }
}
