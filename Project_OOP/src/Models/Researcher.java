package Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Researcher extends Employee {
    private List<ResearchPaper> researchPapers;
    private List<ResearchProject> researchProjects;

    public Researcher(String username, String userId, String firstName, String lastName, String email, String password) {
        super(username, userId, firstName, lastName, email, password);
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void addResearchPaper(ResearchPaper paper) {
        this.researchPapers.add(paper);
        System.out.println("Researcher " + getNameFirst() + " added a new research paper: " + paper.getTitle());
    }

    public void addResearchProject(ResearchProject project) {
        this.researchProjects.add(project);
        System.out.println("Researcher " + getNameFirst() + " joined the research project: " + project.getTopic());
    }

    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.sort(comparator);
        researchPapers.forEach(System.out::println);
    }

    public int calculateHIndex() {
        int hIndex = 0;
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper paper : researchPapers) {
            citations.add(paper.getCitations());
        }
        citations.sort(Comparator.reverseOrder());
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }

    // Проверка, может ли быть супервайзером
    public boolean isEligibleSupervisor() {
        int hIndex = calculateHIndex(); // Вычисляем текущий h-index
        return hIndex >= 3;
    }

    // Метод для назначения супервайзера
    public static void assignSupervisorToStudent(Student student, Researcher supervisor) {
        if (!supervisor.isEligibleSupervisor()) {
            throw new IllegalArgumentException("Research Supervisor must have an h-index of 3 or higher.");
        }
        if (student.getYear() != 4) {
            throw new IllegalArgumentException("Only 4th-year students can have a Research Supervisor.");
        }
        student.setResearchSupervisor(supervisor);
        System.out.println("Research Supervisor " + supervisor.getNameFirst() + " assigned to student: " + student.getNameFirst());
    }

	@Override
	public void receiveNotification(String message) {		
	}
}
