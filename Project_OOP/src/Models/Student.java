package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends User {

    private double gpa; // Средний балл
    private int year; // Год обучения
    private int credits; // Общее количество кредитов
    private List<Course> courses; // Список курсов, на которые записан студент
    private Map<Course, Mark> transcript; // Транскрипт с оценками по курсам
    private Specialty specialty; // Специальность студента (enum)
    private List<String> organizations; // Организации, членом которых является студент
    private boolean isHeadOfOrganization; // Является ли студент главой какой-либо организации
    private Researcher researchSupervisor; // Супервизор для студентов 4-го курса
    private List<Lesson> schedule; // Список уроков в расписании

    public Student(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   double gpa, int year, int credits, List<Course> courses, Map<Course, Mark> transcript, Specialty specialty) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.gpa = gpa;
        this.year = year;
        this.credits = credits;
        this.courses = courses != null ? courses : new ArrayList<>();
        this.transcript = transcript;
        this.specialty = specialty;
        this.organizations = new ArrayList<>();
        this.isHeadOfOrganization = false;
	this.schedule = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
	
     public List<Lesson> getSchedule() {
        return schedule;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<Course, Mark> getTranscript() {
        return transcript;
    }

    public void setTranscript(Map<Course, Mark> transcript) {
        this.transcript = transcript;
    }

    public List<String> getOrganizations() {
        return organizations;
    }

    public boolean isHeadOfOrganization() {
        return isHeadOfOrganization;
    }

    public void setHeadOfOrganization(boolean headOfOrganization) {
        isHeadOfOrganization = headOfOrganization;
    }

    public Researcher getResearchSupervisor() {
        return researchSupervisor;
    }

    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }

  
    public void addLesson(Lesson lesson) {
        if (!schedule.contains(lesson)) {
            schedule.add(lesson);
        }
    }

    public void removeLesson(Lesson lesson) {
        schedule.remove(lesson);
    }
}

	

    // Добавление студента в организацию
    public void joinOrganization(String organizationName) {
        if (!organizations.contains(organizationName)) {
            organizations.add(organizationName);
        } else {
            throw new IllegalArgumentException("Student is already a member of the organization: " + organizationName);
        }
    }

    // Добавление курса с проверкой лимита по кредитам
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            throw new IllegalArgumentException("Student is already registered for the course: " + course.getName());
        }
        if (credits + course.getCredits() > 21) {
            throw new IllegalArgumentException("Student cannot register for more than 21 credits in a semester.");
        }
        courses.add(course);
        credits += course.getCredits();
    }

    // Удаление курса
    public void removeCourse(Course course) {
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("Student is not registered for the course: " + course.getName());
        }
        courses.remove(course);
        credits -= course.getCredits();
    }

    // Проверка количества проваленных курсов
    public boolean hasExceededFailLimit() {
        long failedCourses = transcript.values().stream()
                .filter(mark -> mark.getTotal() < 50)
                .count();
        return failedCourses > 3;
    }

    // Сортировка курсов по названию
    public List<Course> getCoursesSortedByName() {
        return courses.stream()
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .toList();
    }

     // Метод для оценки преподавателя
    public void rateTeacher(Teacher teacher, int rating) {
        try {
            teacher.addRating(rating); // Передаём оценку в метод преподавателя
            System.out.println("Student " + getNameFirst() + " rated Teacher " +
                    teacher.getNameFirst() + " with " + rating + " stars.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error while rating teacher: " + e.getMessage());
        }
    }
    
	// Получение списка курсов студента с указанием типа (Major, Minor, Free Elective)
	public void listCoursesWithTypes() {
	    System.out.println("Courses for " + getNameFirst() + " " + getNameLast() + ":");
	    for (Course course : courses) {
	        CourseType type = course.determineCourseTypeForStudent(this);
	        System.out.println("- " + course.getName() + " (" + type + ")");
	    }
	}


    // Реализация equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getUserId().equals(student.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getNameFirst() + " " + getNameLast() + '\'' +
                ", gpa=" + gpa +
                ", year=" + year +
                ", credits=" + credits +
                ", courses=" + courses.size() +
                ", specialty=" + specialty +
                ", organizations=" + organizations +
                ", isHeadOfOrganization=" + isHeadOfOrganization +
                '}';
    }

	@Override
	public void receiveNotification(String message) {
	}
}
