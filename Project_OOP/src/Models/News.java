package Models;

public class News {
    private String title;
    private String content;
    private String author;
    private String timestamp;

    public News(String title, String content, String author, String timestamp) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "News{" +
               "title='" + title + '\'' +
               ", content='" + content + '\'' +
               ", author='" + author + '\'' +
               ", timestamp='" + timestamp + '\'' +
               '}';
    }
}


