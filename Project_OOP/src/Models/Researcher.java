import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Researcher extends Employee {
    private int hIndex;
    private List<ResearchPaper> researchPapers;
    private List<ResearchProject> researchProjects;

    public Researcher(String name, String id, int hIndex) {
        super(name, id);
        this.hIndex = hIndex;
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    public int getHIndex() {
        return hIndex;
    }

    public void setHIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
        System.out.println("Added research paper: " + paper.getTitle());
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void addResearchProject(ResearchProject project) {
        researchProjects.add(project);
        System.out.println("Added research project: " + project.getTopic());
    }

    public void calculateHIndex() {
        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {
            if (researchPapers.get(i).getCitations() >= i + 1) {
                hIndex++;
            }
        }
        this.hIndex = hIndex;
        System.out.println("Calculated H-Index: " + hIndex);
    }

    @Override
    public String toString() {
        return "Researcher{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", hIndex=" + hIndex +
                ", researchPapers=" + researchPapers.size() +
                ", researchProjects=" + researchProjects.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Researcher)) return false;
        Researcher that = (Researcher) o;
        return hIndex == that.hIndex && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), hIndex);
    }
}
