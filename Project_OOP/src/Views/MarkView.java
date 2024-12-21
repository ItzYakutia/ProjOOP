package Views;

import Models.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MarkView {

    // Установка оценки
    public void setMark(Student student, Course course, double attestation1, double attestation2, double finalExam, List<Mark> marks, MarkCalculator markCalculator) {
        Mark mark = findMark(student, course, marks);
        if (mark == null) {
            mark = new Mark(student, course, attestation1, attestation2, finalExam);
            marks.add(mark);
        } else {
            mark.setAttestation1(attestation1);
            mark.setAttestation2(attestation2);
            mark.setFinalExam(finalExam);
        }
        double total = markCalculator.calculateTotal(attestation1, attestation2, finalExam);
        mark.setTotal(total);
        System.out.println("Mark set successfully for student " + student.getNameFirst() + " in course " + course.getName() + ".");
    }

    // Просмотр транскрипта студента
    public void viewTranscript(String studentId, List<Mark> marks) {
        List<Mark> studentMarks = marks.stream()
                .filter(mark -> mark.getStudent().getUserId().equals(studentId))
                .collect(Collectors.toList());

        if (studentMarks.isEmpty()) {
            System.out.println("Transcript is empty. No marks are available for this student.");
            return;
        }

        System.out.println("Transcript for student: " + studentMarks.get(0).getStudent().getNameFirst() + " " + studentMarks.get(0).getStudent().getNameLast());
        for (Mark mark : studentMarks) {
            System.out.println("Course: " + mark.getCourse().getName() + ", Total Mark: " + mark.getTotal());
        }
    }

    // Проверка, провалил ли студент курс
    public void checkIfCourseFailed(Student student, Course course, List<Mark> marks) {
        Mark mark = findMark(student, course, marks);
        if (mark != null && mark.getTotal() < 50) {
            System.out.println("Student " + student.getNameFirst() + " has failed the course " + course.getName() + ".");
        } else {
            System.out.println("Student " + student.getNameFirst() + " has passed the course " + course.getName() + ".");
        }
    }

    // Проверка, провалил ли студент более 3 курсов
    public void checkIfStudentFailedTooManyCourses(Student student, List<Mark> marks) {
        long failedCourses = marks.stream()
                .filter(mark -> mark.getStudent().equals(student) && mark.getTotal() < 50)
                .count();

        if (failedCourses > 3) {
            System.out.println("Student " + student.getNameFirst() + " has failed more than 3 courses.");
        } else {
            System.out.println("Student " + student.getNameFirst() + " has failed " + failedCourses + " courses.");
        }
    }

    // Генерация отчёта об успеваемости студентов в курсе
    public void generateCourseReport(Course course, List<Mark> marks) {
        System.out.println("Performance Report for Course: " + course.getName());
        marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .forEach(mark -> System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                        ", Total Mark: " + mark.getTotal()));
    }

    // Генерация отчёта об успеваемости студента
    public void generateStudentReport(Student student, List<Mark> marks) {
        System.out.println("Performance Report for Student: " + student.getNameFirst() + " " + student.getNameLast());
        marks.stream()
                .filter(mark -> mark.getStudent().equals(student))
                .forEach(mark -> System.out.println("Course: " + mark.getCourse().getName() + ", Total Mark: " + mark.getTotal()));
    }

    // Получение лучших студентов в курсе
    public void getTopStudents(Course course, int topN, List<Mark> marks) {
        System.out.println("Top " + topN + " students in course " + course.getName() + ":");
        marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .sorted(Comparator.comparingDouble(Mark::getTotal).reversed())
                .limit(topN)
                .forEach(mark -> System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                        ", Total Mark: " + mark.getTotal()));
    }

    // Получение студентов с худшими результатами в курсе
    public void getLowestPerformingStudents(Course course, int bottomN, List<Mark> marks) {
        System.out.println("Bottom " + bottomN + " students in course " + course.getName() + ":");
        marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .sorted(Comparator.comparingDouble(Mark::getTotal))
                .limit(bottomN)
                .forEach(mark -> System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                        ", Total Mark: " + mark.getTotal()));
    }

    // Вспомогательный метод для поиска оценки
    private Mark findMark(Student student, Course course, List<Mark> marks) {
        return marks.stream()
                .filter(mark -> mark.getStudent().equals(student) && mark.getCourse().equals(course))
                .findFirst()
                .orElse(null);
    }
}
