package Views;

import Models.Dean;
import Models.Rector;
import Models.ResearchProject;

import java.util.List;
import java.util.Scanner;

public class RectorView {
    private Scanner scanner;

    public RectorView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(Rector rector) {
        while (true) {
            System.out.println("=== Rector Menu ===");
            System.out.println("1. Manage Budget");
            System.out.println("2. Approve Program");
            System.out.println("3. Revoke Program");
            System.out.println("4. Appoint Dean");
            System.out.println("5. Oversee Research Projects");
            System.out.println("6. Address University Issues");
            System.out.println("7. Sign Document");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageBudget(rector);
                case 2 -> approveProgram(rector);
                case 3 -> revokeProgram(rector);
                case 4 -> appointDean(rector);
                case 5 -> overseeResearchProjects(rector);
                case 6 -> addressUniversityIssues(rector);
                case 7 -> signDocument(rector);
                case 0 -> {
                    System.out.println("Exiting Rector Menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void manageBudget(Rector rector) {
        System.out.print("Enter budget adjustment amount: ");
        double amount = scanner.nextDouble();
        try {
            rector.manageBudget(amount);
            System.out.println("Updated university budget: $" + rector.getUniversityBudget());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void approveProgram(Rector rector) {
        System.out.print("Enter program to approve: ");
        String program = scanner.nextLine();
        rector.approveProgram(program);
    }

    public void revokeProgram(Rector rector) {
        System.out.print("Enter program to revoke: ");
        String program = scanner.nextLine();
        rector.revokeProgram(program);
    }

    public void appointDean(Rector rector) {
        System.out.print("Enter Dean name: ");
        String deanName = scanner.nextLine();
        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine();
        Dean dean = new Dean("username", "password", "D001", deanName, "LastName", "email@example.com", List.of(), faculty);
        rector.appointDean(dean, faculty);
    }

    public void overseeResearchProjects(Rector rector) {
        System.out.println("Overseeing research projects (stubbed for now):");
        List<ResearchProject> projects = List.of(new ResearchProject("AI Research", "Improving AI systems", 100000));
        rector.overseeResearchProjects(projects);
    }

    public void addressUniversityIssues(Rector rector) {
        System.out.print("Enter issue to resolve: ");
        String issue = scanner.nextLine();
        rector.addressUniversityIssues(issue);
    }

    public void signDocument(Rector rector) {
        System.out.print("Enter document name: ");
        String document = scanner.nextLine();
        rector.signDocument(document);
    }
}
