package Controllers;

import Models.*;
import Views.TeacherView;

import java.util.Comparator;
import java.util.List;

public class TeacherController {

    private final TeacherView teacherView; // Представление для взаимодействия с пользователем

    public TeacherController(TeacherView teacherView) {
        this.teacherView = teacherView;
    }

    // Сортировка преподавателей по фамилии (алфавитно)
    public void sortTeachersByLastName(List<Teacher> teachers) {
        teachers.sort(Comparator.comparing(Teacher::getNameLast));
        teacherView.displaySortedTeachers(teachers);
    }

    // Просмотр курсов преподавателя
    public void viewCourses(Teacher teacher) {
        teacherView.displayTeacherCourses(teacher.getCourses());
    }

    // Управление курсами (добавление или удаление)
    public void manageCourse(Teacher teacher, Course course, boolean isAdd) {
        try {
            if (isAdd) {
                teacher.addCourse(course);
                teacherView.displaySuccessMessage("Course added successfully.");
            } else {
                teacher.removeCourse(course);
                teacherView.displaySuccessMessage("Course removed successfully.");
            }
        } catch (IllegalArgumentException e) {
            teacherView.displayErrorMessage(e.getMessage());
        }
    }

    // Отправка жалобы
    public void sendComplaint(Teacher teacher, Student student, Course course, String text, UrgencyLevel urgency) {
        try {
            teacher.sendComplaint(student, course, text, urgency);
            teacherView.displaySuccessMessage("Complaint sent successfully.");
        } catch (IllegalArgumentException e) {
            teacherView.displayErrorMessage(e.getMessage());
        }
    }

    // Выставление оценок студенту
    public void assignMarks(Teacher teacher, Student student, Course course, double attestation1, double attestation2, double finalExam) {
        try {
            teacher.assignMark(student, course, attestation1, attestation2, finalExam);
            teacherView.displaySuccessMessage("Marks assigned successfully.");
        } catch (IllegalArgumentException e) {
            teacherView.displayErrorMessage(e.getMessage());
        }
    }

    // Просмотр студентов на курсе
    public void viewStudentsInCourse(Course course) {
        teacherView.displayStudentsInCourse(course.getEnrolledStudents());
    }

     // Метод для получения средней оценки преподавателя
    public void displayAverageRating(Teacher teacher) {
        double averageRating = teacher.getAverageRating();
        teacherView.displayAverageRating(teacher, averageRating);
    }
}
