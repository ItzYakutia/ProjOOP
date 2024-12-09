import java.util.ArrayList;
import java.util.List;

public class Researcher extends Employee {
    private int hIndex;
    private List<ResearchPaper> researchPapers;

    public Researcher(String name, String id, int hIndex) {
        super(name, id);
        this.hIndex = hIndex;
        this.researchPapers = new ArrayList<>();
    }

    public int getHIndex() {
        return hIndex;
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }
}
