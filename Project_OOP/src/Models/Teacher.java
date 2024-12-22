package Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Teacher extends Employee {
    private Title title; // Звание преподавателя (LECTOR, SENIOR_LECTOR, PROFESSOR, etc.)
    private List<Course> courses; // Курсы, которые ведет преподаватель
    private List<String> complaints; // Жалобы на студентов
    private Researcher researcherProfile; // Профиль исследователя (если есть)
    private List<Integer> ratings; // Оценки преподавателю (1-5)
    private List<Lesson> schedule; // Список уроков в расписании


    // Конструктор
    public Teacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                   Title title) {
        super(username, password, userId, nameFirst, nameLast, email);
        this.title = title;
        this.courses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.schedule = new ArrayList<>();
        // Если учитель является PROFESSOR, создаём профиль Researcher
        if (title == Title.PROFESSOR) {
            this.researcherProfile = new Researcher(username, userId, nameFirst, nameLast, email, password);
        }
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
    
    public List<Lesson> getSchedule() {
        return schedule;
    }

    public Researcher getResearcherProfile() {
        return researcherProfile;
    }

    // Метод для проверки, является ли преподаватель Researcher
    public boolean isResearcher() {
        return researcherProfile != null;
    }

    // Превращение в Researcher (для преподавателей, которые не PROFESSOR)
    public void becomeResearcher() {
        if (researcherProfile == null) {
            this.researcherProfile = new Researcher(getUsername(), getUserId(), getNameFirst(), getNameLast(), getEmail(), getPassword());
            System.out.println(getNameFirst() + " " + getNameLast() + " is now a Researcher.");
        } else {
            System.out.println(getNameFirst() + " " + getNameLast() + " is already a Researcher.");
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

	
    public void addLessonToSchedule(Lesson lesson) {
        if (!schedule.contains(lesson)) {
            schedule.add(lesson);
        }
    }

    public void removeLessonFromSchedule(Lesson lesson) {
        schedule.remove(lesson);
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
	    //добавление рейтинга
	public void addRating(int rating) {
	    // Проверяем, чтобы оценка находилась в диапазоне от 1 до 5
	    if (rating < 1 || rating > 5) {
	        throw new IllegalArgumentException("Rating must be between 1 and 5.");
	    }
	    ratings.add(rating); // Добавляем оценку в список
	}
	
	//Метод вычисления средней оценки:
	public double getAverageRating() {
	    // Если список пустой, возвращаем 0.0
	    if (ratings.isEmpty()) {
	        return 0.0;
	    }
	    // Вычисляем среднее значение всех оценок в списке
	    return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
	}
	
	//удаление учителя из курса 
	public void removeCourse(Course course) {
	    if (courses.contains(course)) {
	        courses.remove(course); // Удаляем курс из списка курсов преподавателя
	    } else {
	        throw new IllegalArgumentException("Course not found for this teacher.");
	    }
	}
	//добавление учителя в курс 
	public void addCourse(Course course) {
	    if (!courses.contains(course)) { // Проверяем, есть ли уже этот курс в списке
	        courses.add(course); // Добавляем курс в список курсов преподавателя
	    } else {
	        throw new IllegalArgumentException("This course is already assigned to the teacher.");
	    }
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
                ", courses=" + courses.size() +
                ", averageRating=" + getAverageRating() +
                ", complaints=" + complaints.size() +
                ", isResearcher=" + isResearcher() +
                '}' ;
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Notification for Teacher " + getNameFirst() + ": " + message);
    }
}
