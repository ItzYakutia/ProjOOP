package Models;

import java.time.LocalDate;
import java.util.List;

public class ResearchPaper {
    private String title;
    private List<String> authors;
    private String journal;
    private LocalDate date;
    private int citations;
    private int pages;
    private String doi;

    public ResearchPaper(String title, List<String> authors, String journal, LocalDate date, int citations, int pages, String doi) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.date = date;
        this.citations = citations;
        this.pages = pages;
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getJournal() {
        return journal;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCitations() {
        return citations;
    }

    public int getPages() {
        return pages;
    }

    public String getDoi() {
        return doi;
    }

    public String getCitation(Format format) {
        switch (format) {
            case PLAINTEXT:
                return title + ". " + String.join(", ", authors) + ". " + journal + ". DOI: " + doi + ".";
            case BIBTEX:
                return "@article{" + title.replaceAll("\\s+", "_") + ",\n" +
                        "  title={" + title + "},\n" +
                        "  author={" + String.join(" and ", authors) + "},\n" +
                        "  journal={" + journal + "},\n" +
                        "  year={" + date.getYear() + "},\n" +
                        "  pages={" + pages + "},\n" +
                        "  doi={" + doi + "}\n" +
                        "}";
            default:
                throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}

enum Format {
    PLAINTEXT,
    BIBTEX
}
