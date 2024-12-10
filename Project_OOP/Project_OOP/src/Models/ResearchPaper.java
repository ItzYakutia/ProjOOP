package Models;

public class ResearchPaper {
    private String title;
    private String authors;
    private String journal;
    private int citations;

    public ResearchPaper(String title, String authors, String journal, int citations) {
        if (citations < 0) {
            throw new IllegalArgumentException("Citations cannot be negative!");
        }
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.citations = citations;
    }

    public String getTitle() {
        return title;
    }

    public int getCitations() {
        return citations;
    }
}
