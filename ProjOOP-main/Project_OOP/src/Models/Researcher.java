package Models;

import java.util.List;

public interface Researcher {
    double calculateHIndex(List<ResearchPaper> papers);
    void printPapers(List<ResearchPaper> papers);
}
