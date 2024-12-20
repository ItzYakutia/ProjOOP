package Models;

import java.util.List;

public class ResearchProject {
    private String topic;
    private List<ResearchPaper> papers;
    private List<Researcher> participants;

    public ResearchProject(String topic, List<ResearchPaper> papers, List<Researcher> participants) {
        this.topic = topic;
        this.papers = papers;
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "ResearchProject{" + "topic='" + topic + '\'' + ", papers=" + papers + ", participants=" + participants + '}';
    }
}
