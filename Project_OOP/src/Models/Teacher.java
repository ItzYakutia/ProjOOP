package Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Teacher extends Employee {

    private Title title; // Звание преподавателя (LECTOR, SENIOR_LECTOR, PROFESSOR, etc.)
    private List<Course> courses; // Курсы, которые ведет преподаватель
    private List<String> complaints; // Жалобы на студентов
    private List<ResearchPaper> researchPapers; // Научные статьи (если преподаватель является исследователем)
    private List<ResearchProject> researchProjects; // Исследовательские проекты (если преподаватель является исследователем)

    // Конструктор
    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   int workingYears, Title title) {
        super(username, password, userId, nameFirst, nameLast, email, workingYears);
        this.title = title;
        this.courses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<String> getComplaints() {
        return complaints;
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    // Методы управления курсами
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            throw new IllegalArgumentException("Course not found.");
        }
    }

    // Методы работы с жалобами
    public void sendComplaint(Student student, Course course, String text, UrgencyLevel urgency) {
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("This course is not assigned to the teacher.");
        }
        String complaint = "Complaint about student: " + student.getNameFirst() + " " + student.getNameLast() +
                ", Course: " + course.getName() +
                ", Urgency: " + urgency +
                ", Text: " + text;
        complaints.add(complaint);
    }

    // Методы работы с оценками
    public void assignMark(Student student, Course course, double attestation1, double attestation2, double finalExam) {
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("This course is not assigned to the teacher.");
        }
        if (attestation1 < 0 || attestation1 > 100 || attestation2 < 0 || attestation2 > 100 || finalExam < 0 || finalExam > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        Mark mark = student.getTranscript().get(course);
        if (mark == null) {
            mark = new Mark(student, course, attestation1, attestation2, finalExam);
            student.getTranscript().put(course, mark);
        } else {
            mark.setAttestation1(attestation1);
            mark.setAttestation2(attestation2);
            mark.setFinalExam(finalExam);
            mark.setTotal(attestation1 + attestation2 + finalExam);
        }
    }

    // Методы работы с научными статьями
    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }

    public void printResearchPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.stream().sorted(comparator).forEach(System.out::println);
    }

    public int calculateHIndex() {
        // Расчет h-индекса на основе количества цитирований статей
        researchPapers.sort(Comparator.comparingInt(ResearchPaper::getCitations).reversed());
        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {
            if (researchPapers.get(i).getCitations() >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }

    // Методы работы с исследовательскими проектами
    public void addResearchProject(ResearchProject project) {
        if (!researchProjects.contains(project)) {
            researchProjects.add(project);
        }
    }

    public void joinResearchProject(ResearchProject project) throws CustomException {
        if (!this.title.equals(Title.PROFESSOR)) {
            throw new CustomException("Only professors can join this research project.");
        }
        addResearchProject(project);
    }

    // Переопределение методов equals, hashCode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return getUserId().equals(teacher.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", title=" + title +
                ", workingYears=" + getWorkingYears() +
                ", courses=" + courses.size() +
                ", complaints=" + complaints.size() +
                ", researchPapers=" + researchPapers.size() +
                ", researchProjects=" + researchProjects.size() +
                '}';
    }
}
