package Controllers;

import Models.ResearchJournal;
import Models.ResearchPaper;
import Models.User;
import Views.ResearchJournalView;

public class ResearchJournalController {
    private ResearchJournal journal;
    private ResearchJournalView view;

    public ResearchJournalController(ResearchJournal journal, ResearchJournalView view) {
        this.journal = journal;
        this.view = view;
    }

    public void showJournalDetails() {
        view.displayJournalDetails(journal);
    }

    public void subscribeUser(User user) {
        journal.subscribe(user);
        view.displayMessage(user.getNameFirst() + " subscribed to " + journal.getName());
    }

    public void publishPaper(ResearchPaper paper) {
        journal.publishPaper(paper);
        view.displayMessage("Paper published: " + paper.getTitle());
    }
}
