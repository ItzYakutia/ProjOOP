package Models;

import java.util.Date;

public class ResearchPaper {
    private String title;
    private String[] authors;
    private Date publicationDate;
    private int citations;

    public ResearchPaper(String title, String[] authors, Date publicationDate, int citations) {
        this.title = title;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.citations = citations;
    }

    public String getTitle() { return title; }
    public int getCitations() { return citations; }

    @Override
    public String toString() {
        return "ResearchPaper{" + "title='" + title + '\'' + ", citations=" + citations + '}';
    }
}
