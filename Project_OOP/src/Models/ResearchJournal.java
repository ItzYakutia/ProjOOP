package Models;

import java.util.ArrayList;
import java.util.List;

public class ResearchJournal {
    private String name; // Название журнала
    private List<User> subscribers; // Подписчики (любые пользователи)
    private List<ResearchPaper> publishedPapers; // Опубликованные статьи

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

    // Подписка пользователя
    public void subscribe(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
            System.out.println(user.getNameFirst() + " subscribed to " + name);
        } else {
            System.out.println(user.getNameFirst() + " is already subscribed to " + name);
        }
    }

    // Отписка пользователя
    public void unsubscribe(User user) {
        if (subscribers.contains(user)) {
            subscribers.remove(user);
            System.out.println(user.getNameFirst() + " unsubscribed from " + name);
        } else {
            System.out.println(user.getNameFirst() + " is not subscribed to " + name);
        }
    }

    // Публикация новой статьи
    public void publishPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
        System.out.println("New paper published in " + name + ": " + paper.getTitle());
        notifySubscribers(paper);
    }

    // Уведомление всех подписчиков о новой статье
    private void notifySubscribers(ResearchPaper paper) {
        for (User subscriber : subscribers) {
            subscriber.receiveNotification("New paper published in " + name + ": " + paper.getTitle());
        }
    }
}
