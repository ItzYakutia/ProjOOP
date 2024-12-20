package Views;

import Controllers.ResearcherController;
import Models.ResearchProject;
import java.util.List;
import java.util.Scanner;

public class ResearcherView {
    private ResearcherController controller;
    private Scanner scanner;

    public ResearcherView(ResearcherController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Researcher Menu ===");
            System.out.println("1. Add Research Project");
            System.out.println("2. List Research Projects");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addResearchProject();
                case 2 -> controller.listResearchProjects();
                case 0 -> System.out.println("Exiting Researcher Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addResearchProject() {
        System.out.print("Enter Research Topic: ");
        String topic = scanner.nextLine();
        controller.addResearchProject(new ResearchProject(topic, null, null));
    }
}
