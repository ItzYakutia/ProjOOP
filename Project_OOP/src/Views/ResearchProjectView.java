package Views;

import java.util.List;

import Models.*;

public class ResearchProjectView {
    public void displayProjectDetails(String topic, List<Researcher> participants) {
        System.out.println("Project Topic: " + topic);
        System.out.println("Participants:");
        for (Researcher researcher : participants) {
            System.out.println("- " + researcher.getUsername());
        }
    }
}