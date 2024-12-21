package Views;

import Models.*;

import java.util.List;
import java.util.Map;

public class StudentView {

    // Отображение всех факультетов
    public void displayFaculties() {
        System.out.println("Available Faculties:");
        for (Faculty faculty : Faculty.values()) {
            System.out.println("- " + faculty + ": " + faculty.getFullName());
        }
    }

    // Отображение специальностей для выбранного факультета
    public void displaySpecialties(Faculty faculty) {
        System.out.println("Specialties in " + faculty.getFullName() + ":");
        switch (faculty) {
            case SITE:
                for (SiteSpecialty specialty : SiteSpecialty.values()) {
                    System.out.println("- " + specialty + ": " + specialty.getFullName());
                }
                break;
            case BS:
                for (BsSpecialty specialty : BsSpecialty.values()) {
                    System.out.println("- " + specialty + ": " + specialty.getFullName());
                }
                break;
            default:
                System.out.println("No specialties available for this faculty.");
        }
    }

    // Подтверждение выбора факультета и специальности
    public void displayFacultyAndSpecialtyChosen(Faculty faculty, String specialty) {
        System.out.println("You have chosen:");
        System.out.println("- Faculty: " + faculty.getFullName());
        System.out.println("- Specialty: " + specialty);
    }

    // Сообщение об ошибке при выборе специальности
    public void displaySpecialtyError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ списка всех доступных курсов
    public void displayCourses(List<Course> courses) {
        System.out.println("Available Courses:");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : courses) {
            System.out.println("- " + course.getName() + " (" + course.getCredits() + " credits): " + course.getDescription());
        }
    }

    // Показ сообщения об успешной регистрации на курс
    public void displayRegistrationSuccess(Course course, Student student) {
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " has been successfully registered for the course: " + course.getName());
    }

    // Показ сообщения об ошибке регистрации на курс
    public void displayRegistrationError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ транскрипта студента
    public void displayTranscript(Student student) {
        System.out.println("Transcript for " + student.getNameFirst() + " " + student.getNameLast() + ":");
        if (student.getTranscript() == null || student.getTranscript().isEmpty()) {
            System.out.println("Transcript is empty. No marks are available.");
            return;
        }
        for (Map.Entry<Course, Mark> entry : student.getTranscript().entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println("- Course: " + course.getName() + ", Mark: " + mark.getTotal());
        }
    }

    // Показ сообщения об отсутствии студента
    public void displayStudentNotFound(String studentId) {
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Показ информации о курсе
    public void displayCourseInfo(Course course) {
        if (course == null) {
            System.out.println("Course not found.");
        } else {
            System.out.println("Course Information:");
            System.out.println("- Name: " + course.getName());
            System.out.println("- Description: " + course.getDescription());
            System.out.println("- Credits: " + course.getCredits());
        }
    }

    // Показ новостей
    public void displayNews(List<News> news) {
        System.out.println("News:");
        if (news.isEmpty()) {
            System.out.println("No news available.");
            return;
        }
        for (News item : news) {
            System.out.println("- " + item.getTitle() + ": " + item.getContent());
        }
    }

    // Показ сообщения о запросе на вступление в организацию
    public void displayJoinOrganizationRequest(String orgName, Student student) {
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " has requested to join the organization: " + orgName);
    }

    // Показ сообщения об успешной оценке курса
    public void displayCourseRatingSuccess(String courseName, int rating, String feedback) {
        System.out.println("Course " + courseName + " has been rated " + rating + " stars.");
        System.out.println("Feedback: " + feedback);
    }

    // Показ сообщения об ошибке оценки курса
    public void displayCourseRatingError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ сортированных студентов
    public void displaySortedStudents(List<Student> students) {
        System.out.println("Sorted Students:");
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() +
                    " (GPA: " + student.getGpa() + ")");
        }
    }

    // Показ результатов проверки проваленных курсов
    public void displayFailedCoursesResult(Student student, long failedCourses) {
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " has failed " + failedCourses + " course(s).");
    }

    // Показ предупреждения о большом количестве проваленных курсов
    public void displayFailedCoursesWarning(Student student) {
        System.out.println("Warning: Student " + student.getNameFirst() + " " + student.getNameLast() +
                " has failed more than 3 courses. Immediate action required.");
    }
}
