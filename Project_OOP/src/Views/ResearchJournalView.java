package Views;

import Models.ResearchJournal;
import Models.ResearchPaper;

public class ResearchJournalView {
    public void displayJournalDetails(ResearchJournal journal) {
        System.out.println("Research Journal: " + journal.getName());
        System.out.println("Published Papers:");
        for (ResearchPaper paper : journal.getPublishedPapers()) {
            System.out.println("- " + paper.getTitle());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
