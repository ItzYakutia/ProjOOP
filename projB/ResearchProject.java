import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;

    public ResearchProject(String topic) {
        this.topic = topic;
        this.publishedPapers = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void addPublishedPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
        System.out.println("Added published paper: " + paper.getTitle());
    }

    public List<Researcher> getParticipants() {
        return participants;
    }

    public void addParticipant(Researcher researcher) {
        participants.add(researcher);
        System.out.println("Added participant: " + researcher.getName());
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "topic='" + topic + '\'' +
                ", publishedPapers=" + publishedPapers.size() +
                ", participants=" + participants.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchProject)) return false;
        ResearchProject that = (ResearchProject) o;
        return Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }
}
