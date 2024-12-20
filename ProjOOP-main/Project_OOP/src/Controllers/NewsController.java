package Controllers;

import Models.News;
import java.util.ArrayList;
import java.util.List;

public class NewsController {
    private List<News> newsList;

    public NewsController() {
        this.newsList = new ArrayList<>();
    }

    public void addNews(News news) {
        newsList.add(news);
        System.out.println("News added: " + news.getTitle());
    }

    public void removeNews(String title) {
        boolean removed = newsList.removeIf(n -> n.getTitle().equals(title));
        if (removed) {
            System.out.println("News removed with title: " + title);
        } else {
            System.out.println("News not found with title: " + title);
        }
    }

    public void listNews() {
        System.out.println("Listing all news:");
        for (News news : newsList) {
            System.out.println(news);
        }
    }
}
