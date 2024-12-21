package Controllers;

import Models.*;
import Views.MarkView;

import java.util.List;

public class MarkController {

    private final MarkView markView;

    public MarkController(MarkView markView) {
        this.markView = markView;
    }

    // Установка оценки
    public void setMark(Student student, Course course, double attestation1, double attestation2, double finalExam, List<Mark> marks, MarkCalculator markCalculator) {
        markView.setMark(student, course, attestation1, attestation2, finalExam, marks, markCalculator);
    }

    // Просмотр транскрипта студента
    public void viewTranscript(String studentId, List<Mark> marks) {
        markView.viewTranscript(studentId, marks);
    }

    // Проверка, провалил ли студент курс
    public void checkIfCourseFailed(Student student, Course course, List<Mark> marks) {
        markView.checkIfCourseFailed(student, course, marks);
    }

    // Проверка, провалил ли студент более 3 курсов
    public void checkIfStudentFailedTooManyCourses(Student student, List<Mark> marks) {
        markView.checkIfStudentFailedTooManyCourses(student, marks);
    }

    // Генерация отчёта об успеваемости студентов в курсе
    public void generateCourseReport(Course course, List<Mark> marks) {
        markView.generateCourseReport(course, marks);
    }

    // Генерация отчёта об успеваемости студента
    public void generateStudentReport(Student student, List<Mark> marks) {
        markView.generateStudentReport(student, marks);
    }

    // Получение лучших студентов в курсе
    public void getTopStudents(Course course, int topN, List<Mark> marks) {
        markView.getTopStudents(course, topN, marks);
    }

    // Получение студентов с худшими результатами в курсе
    public void getLowestPerformingStudents(Course course, int bottomN, List<Mark> marks) {
        markView.getLowestPerformingStudents(course, bottomN, marks);
    }
}
