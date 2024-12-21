package Models;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Rector extends Employee {
    private static Rector instance;
    private double universityBudget;

    private Rector(String username, String userId, String firstName, String lastName, String email, double budget, String password) {
        super(username, userId, firstName, lastName, email, password);
        this.universityBudget = budget;
    }

    public static Rector getInstance(String username, String userId, String firstName, String lastName, String email, double budget, String password) {
        if (instance == null) {
            instance = new Rector(username, userId, firstName, lastName, email, budget, password);
        }
        return instance;
    }

    public double getUniversityBudget() {
        return universityBudget;
    }

    public void manageBudget(double amount) throws IllegalArgumentException {
        if (amount < 0 && Math.abs(amount) > universityBudget) {
            throw new IllegalArgumentException("Not enough budget to perform this operation!");
        }
        universityBudget += amount;
        System.out.println("Budget updated. Current budget: " + universityBudget);
    }

    public void approveDeanDecision(String decision) {
        System.out.println("Rector " + getNameFirst() + " approved the dean's decision: " + decision);
    }

    public void allocateFunding(String facultyName, double amount) throws IllegalArgumentException {
        if (amount > universityBudget) {
            throw new IllegalArgumentException("Not enough budget to allocate " + amount + " to " + facultyName);
        }
        universityBudget -= amount;
        System.out.println("Allocated " + amount + " to " + facultyName + ". Remaining budget: " + universityBudget);
    }

    public void signAgreement(String agreementName) {
        System.out.println("Rector " + getNameFirst() + " signed the agreement: " + agreementName);
    }

    public void printAllResearchPapers(List<Researcher> researchers, Comparator<ResearchPaper> comparator) {
        List<ResearchPaper> allPapers = researchers.stream()
                .flatMap(researcher -> researcher.getResearchPapers().stream())
                .collect(Collectors.toList());
        allPapers.sort(comparator);
        allPapers.forEach(System.out::println);
    }

    public Researcher getTopCitedResearcherBySchool(List<Researcher> researchers, String schoolName) {
        return researchers.stream()
                .filter(researcher -> schoolName.equals(researcher.getFaculty()))
                .max(Comparator.comparingInt(Researcher::calculateHIndex))
                .orElse(null);
    }

    public Researcher getTopCitedResearcherOfYear(List<Researcher> researchers, int year) {
        return researchers.stream()
                .max(Comparator.comparingInt(researcher ->
                        researcher.getResearchPapers().stream()
                                .filter(paper -> paper.getPublicationDate().getYear() + 1900 == year)
                                .mapToInt(ResearchPaper::getCitations)
                                .sum()))
                .orElse(null);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Rector " + getNameFirst() + " received notification: " + message);
    }
}
