package Models;

import java.util.ArrayList;
import java.util.List;

public class ResearchJournal {
    private String name;
    private List<User> subscribers; 
    private List<ResearchPaper> publishedPapers;

    public ResearchJournal(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void subscribe(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
        }
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public void publishPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
        notifySubscribers(paper);
    }

    private void notifySubscribers(ResearchPaper paper) {
        for (User subscriber : subscribers) {
            subscriber.receiveNotification("New paper published in " + name + ": " + paper.getTitle());
        }
    }
}
