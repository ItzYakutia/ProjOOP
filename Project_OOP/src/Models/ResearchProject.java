package Models;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;
    private Researcher supervisor;

    public ResearchProject(String topic, Researcher supervisor) {
        this.topic = topic;
        this.supervisor = supervisor;
        this.publishedPapers = new ArrayList<>();
        this.participants = new ArrayList<>();
        this.participants.add(supervisor); // Супервайзер автоматически добавляется
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

    public List<Researcher> getParticipants() {
        return participants;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    public void addResearchPaper(ResearchPaper paper) {
        this.publishedPapers.add(paper);
    }

    public void addParticipant(Researcher researcher) {
        if (researcher == null) {
            throw new IllegalArgumentException("Only Researchers can participate in the project.");
        }
        this.participants.add(researcher);
    }

    public void approveDiplomaProject(String projectTitle, Researcher researcher) {
        if (!participants.contains(researcher)) {
            throw new IllegalArgumentException("Only participants of the project can submit a diploma project.");
        }
        System.out.println("Diploma project \"" + projectTitle + "\" approved for Researcher: " + researcher.getNameFirst() + " " + researcher.getNameLast());
    }
}
