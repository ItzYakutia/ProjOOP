import java.util.Date;
import java.util.Objects;

public class ResearchPaper {
    private String title;
    private String authors;
    private String journal;
    private String doi;
    private int citations;
    private int pages;
    private Date publicationDate;

    public ResearchPaper(String title, String authors, String journal, String doi, int citations, int pages, Date publicationDate) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.doi = doi;
        this.citations = citations;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    public String getCitationInBibTex() {
        return "@article{" + doi + ", title={" + title + "}, author={" + authors + "}, journal={" + journal + "}, year={" + publicationDate.getYear() + "}}";
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", journal='" + journal + '\'' +
                ", doi='" + doi + '\'' +
                ", citations=" + citations +
                ", pages=" + pages +
                ", publicationDate=" + publicationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchPaper)) return false;
        ResearchPaper that = (ResearchPaper) o;
        return Objects.equals(doi, that.doi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doi);
    }
}
