package Views;

import Models.*;

import java.util.List;

public class TeacherView {

    // Показ успешного добавления преподавателя
    public void displayTeacherAdded(Teacher teacher) {
        System.out.println("Teacher added successfully: " + teacher.getNameFirst() + " " + teacher.getNameLast());
    }

    // Показ ошибки при добавлении преподавателя
    public void displayTeacherAdditionError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ успешного удаления преподавателя
    public void displayTeacherRemoved(Teacher teacher) {
        System.out.println("Teacher removed successfully: " + teacher.getNameFirst() + " " + teacher.getNameLast());
    }

    // Показ ошибки при удалении преподавателя
    public void displayTeacherRemovalError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ списка студентов, зарегистрированных на курс
    public void displayStudentsInCourse(List<Student> students, Course course) {
        System.out.println("Students registered for course: " + course.getName());
        if (students.isEmpty()) {
            System.out.println("No students registered for this course.");
        } else {
            for (Student student : students) {
                System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() + " (ID: " + student.getUserId() + ")");
            }
        }
    }

    // Показ успешного выставления оценки
    public void displayMarkSetSuccess(Student student, Course course, Mark mark) {
        System.out.println("Mark set successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Course: " + course.getName() + ", Total Mark: " + mark.getTotal());
    }

    // Показ ошибки при выставлении оценки
    public void displayMarkSetError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ успешной отправки жалобы
    public void displayComplaintSent(String complaint) {
        System.out.println("Complaint sent successfully: " + complaint);
    }

    // Показ ошибки при отправке жалобы
    public void displayComplaintError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
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

    // Показ информации о студенте
    public void displayStudentInfo(Student student) {
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student Information:");
            System.out.println("- Name: " + student.getNameFirst() + " " + student.getNameLast());
            System.out.println("- GPA: " + student.getGpa());
            System.out.println("- Year: " + student.getYear());
            System.out.println("- Credits: " + student.getCredits());
        }
    }

    // Показ успешной загрузки силлабуса
    public void displaySyllabusLoaded(Course course) {
        System.out.println("Syllabus loaded successfully for course: " + course.getName());
    }

    // Показ ошибки при загрузке силлабуса
    public void displaySyllabusError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Показ сообщения об отправке
    public void displayMessageSent(String recipientId, String text) {
        System.out.println("Message sent successfully to employee ID: " + recipientId);
        System.out.println("Message: " + text);
    }

    // Показ ошибки при отправке сообщения
    public void displayMessageError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
