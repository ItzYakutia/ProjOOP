package Views;

import Models.*;

import java.util.List;
import java.util.Map;

public class StudentView {

    // Показ информации о студенте
    public void displayStudentInfo(Student student) {
        System.out.println("Student Information:");
        System.out.println("Name: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("User ID: " + student.getUserId());
        System.out.println("GPA: " + student.getGpa());
        System.out.println("Year: " + student.getYear());
        System.out.println("Specialty: " + student.getSpecialty().getDisplayName());
        System.out.println("Credits: " + student.getCredits());
        System.out.println("Organizations: " + student.getOrganizations());
        System.out.println("Head of Organization: " + (student.isHeadOfOrganization() ? "Yes" : "No"));
    }
    public void displayResearcherProfileCreated(Researcher researcher) {
        System.out.println("Researcher profile created for Student: " + researcher.getNameFirst() + " " + researcher.getNameLast());
    }

    public void displayResearcherAssignmentError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
    // Показ успешного добавления студента в организацию
    public void displayOrganizationJoined(String organizationName, Student student) {
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " has joined the organization: " + organizationName);
    }

    // Показ установки роли главы организации
    public void displayHeadOfOrganizationSet(Student student, boolean isHead) {
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " is now " + (isHead ? "the Head of an Organization." : "no longer the Head of an Organization."));
    }

    // Показ успешной регистрации на курс
    public void displayCourseRegistrationSuccess(Course course, Student student) {
        System.out.println("Student " + student.getNameFirst() + " successfully registered for course: " + course.getName());
    }

    // Показ успешного удаления с курса
    public void displayCourseUnregistrationSuccess(Course course, Student student) {
        System.out.println("Student " + student.getNameFirst() + " successfully unregistered from course: " + course.getName());
    }

    // Показ транскрипта
    public void displayTranscript(Student student) {
        System.out.println("Transcript for " + student.getNameFirst() + " " + student.getNameLast() + ":");
        if (student.getTranscript() == null || student.getTranscript().isEmpty()) {
            System.out.println("Transcript is empty.");
            return;
        }
        for (Map.Entry<Course, Mark> entry : student.getTranscript().entrySet()) {
            System.out.println("- Course: " + entry.getKey().getName() + ", Mark: " + entry.getValue().getTotal());
        }
    }

    // Показ отсортированных курсов
    public void displaySortedCoursesByName(List<Course> courses, Student student) {
        System.out.println("Courses sorted by name for " + student.getNameFirst() + ":");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }

    // Показ превышения лимита провалов
    public void displayFailLimitExceeded(Student student) {
        System.out.println("Student " + student.getNameFirst() + " has exceeded the fail limit!");
    }

    // Показ допустимого лимита провалов
    public void displayFailLimitOk(Student student) {
        System.out.println("Student " + student.getNameFirst() + " is within the fail limit.");
    }

    // Показ успешной оценки преподавателя
    public void displayTeacherRatedSuccess(Teacher teacher, int rating) {
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " successfully rated with " + rating + " stars.");
    }

    // Отображение средней оценки преподавателя
public void displayTeacherAverageRating(Teacher teacher) {
    System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
            " has an average rating of: " + teacher.getAverageRating());
}
    
    // Показ информации о преподавателе
    public void displayTeacherInfo(Teacher teacher) {
        System.out.println("Teacher Information:");
        System.out.println("Name: " + teacher.getNameFirst() + " " + teacher.getNameLast());
        System.out.println("Title: " + teacher.getTitle());
        System.out.println("Courses: " + teacher.getCourses().size());
        System.out.println("Average Rating: " + teacher.getAverageRating());
    }

    // Показ ошибки
    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
