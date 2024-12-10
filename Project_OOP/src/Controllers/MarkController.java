package Controllers;

import Models.*;
import java.util.*;

public class MarkController {

    private List<Mark> marks; // Список всех оценок
    private MarkCalculator markCalculator; // Калькулятор для расчёта итоговых оценок

    public MarkController(List<Mark> marks, MarkCalculator markCalculator) {
        this.marks = marks;
        this.markCalculator = markCalculator;
    }

    // Установка оценки за аттестацию или экзамен
    public void setMark(Student student, Course course, double attestation1, double attestation2, double finalExam) {
        Mark mark = findMark(student, course);
        if (mark == null) {
            // Если оценки ещё нет, создаём новую
            mark = new Mark(student, course, attestation1, attestation2, finalExam);
            marks.add(mark);
        } else {
            // Обновляем существующие оценки
            mark.setAttestation1(attestation1);
            mark.setAttestation2(attestation2);
            mark.setFinalExam(finalExam);
        }
        // Рассчитываем итоговую оценку
        double total = markCalculator.calculateTotal(attestation1, attestation2, finalExam);
        mark.setTotal(total);
        System.out.println("Mark set successfully for student " + student.getNameFirst() + " in course " + course.getName() + ".");
    }

    // Получение транскрипта студента
    public Map<Course, Mark> getTranscript(Student student) {
        Map<Course, Mark> transcript = new HashMap<>();
        for (Mark mark : marks) {
            if (mark.getStudent().equals(student)) {
                transcript.put(mark.getCourse(), mark);
            }
        }
        return transcript;
    }

    // Проверка, провалил ли студент указанный курс
    public boolean isCourseFailed(Student student, Course course) {
        Mark mark = findMark(student, course);
        return mark != null && mark.getTotal() < 50;
    }

    // Проверка, провалил ли студент более 3 курсов
    public boolean hasStudentFailedTooManyCourses(Student student) {
        int failedCount = 0;
        for (Mark mark : marks) {
            if (mark.getStudent().equals(student) && mark.getTotal() < 50) {
                failedCount++;
            }
        }
        return failedCount > 3;
    }

    // Генерация отчёта об успеваемости студентов в курсе
    public void generateCourseReport(Course course) {
        System.out.println("Performance Report for Course: " + course.getName());
        for (Mark mark : marks) {
            if (mark.getCourse().equals(course)) {
                System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                        ", Total Mark: " + mark.getTotal());
            }
        }
    }

    // Генерация отчёта об успеваемости студента
    public void generateStudentReport(Student student) {
        System.out.println("Performance Report for Student: " + student.getNameFirst() + " " + student.getNameLast());
        for (Mark mark : marks) {
            if (mark.getStudent().equals(student)) {
                System.out.println("Course: " + mark.getCourse().getName() + ", Total Mark: " + mark.getTotal());
            }
        }
    }

    // Получение списка лучших студентов в курсе
    public List<Student> getTopStudents(Course course, int topN) {
        return marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .sorted(Comparator.comparingDouble(Mark::getTotal).reversed()) // Сортировка по убыванию итоговой оценки
                .limit(topN)
                .map(Mark::getStudent)
                .toList();
    }

    // Получение списка студентов с худшими результатами в курсе
    public List<Student> getLowestPerformingStudents(Course course, int bottomN) {
        return marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .sorted(Comparator.comparingDouble(Mark::getTotal)) // Сортировка по возрастанию итоговой оценки
                .limit(bottomN)
                .map(Mark::getStudent)
                .toList();
    }

    // Вспомогательный метод для поиска оценки по студенту и курсу
    private Mark findMark(Student student, Course course) {
        return marks.stream()
                .filter(mark -> mark.getStudent().equals(student) && mark.getCourse().equals(course))
                .findFirst()
                .orElse(null);
    }
}
