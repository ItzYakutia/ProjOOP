package Models;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String topic;
    private List<Researcher> participants;

    public ResearchProject(String topic) {
        this.topic = topic;
        this.participants = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void addParticipant(Researcher researcher) throws Exception {
        if (!(researcher instanceof Researcher)) {
            throw new Exception("Only researchers can be participants!");
        }
        participants.add(researcher);
    }

    public List<Researcher> getParticipants() {
        return participants;
    }
}
