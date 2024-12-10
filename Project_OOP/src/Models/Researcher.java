package Models;

import java.util.ArrayList;
import java.util.List;

public class Researcher extends User {
    private double hIndex;
    private List<ResearchPaper> researchPapers;

    public Researcher(String username, String password, String userId, String nameFirst, String nameLast, String email,
    		double hIndex) {
    		super(username, password, userId, nameFirst, nameLast, email);
        this.hIndex = hIndex;
        this.researchPapers = new ArrayList<>();
    }

    public double getHIndex() {
        return hIndex;
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }
}
