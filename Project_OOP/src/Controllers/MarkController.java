package Controllers;

import Models.*;
import Views.MarkView;

import java.util.List;
import java.util.stream.Collectors;

public class MarkController {

    private final MarkView markView;

    public MarkController(MarkView markView) {
        this.markView = markView;
    }

    // Установка оценки
    public void setMark(Student student, Course course, double attestation1, double attestation2, double finalExam, List<Mark> marks) {
        try {
            Mark mark = marks.stream()
                    .filter(m -> m.getStudent().equals(student) && m.getCourse().equals(course))
                    .findFirst()
                    .orElse(null);

            if (mark == null) {
                mark = new Mark(student, course, attestation1, attestation2, finalExam);
                marks.add(mark);
            } else {
                mark.setAttestation1(attestation1);
                mark.setAttestation2(attestation2);
                mark.setFinalExam(finalExam);
            }

            markView.displaySuccessMessage("Mark set successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
        } catch (IllegalArgumentException e) {
            markView.displayErrorMessage(e.getMessage());
        }
    }

    // Просмотр транскрипта студента
    public void viewTranscript(Student student, List<Mark> marks) {
        List<Mark> studentMarks = marks.stream()
                .filter(mark -> mark.getStudent().equals(student))
                .collect(Collectors.toList());

        if (studentMarks.isEmpty()) {
            markView.displayErrorMessage("No marks available for student: " + student.getNameFirst() + " " + student.getNameLast());
        } else {
            markView.displayTranscript(student, studentMarks);
        }
    }

    // Генерация отчёта по курсу
    public void generateCourseReport(Course course, List<Mark> marks) {
        List<Mark> courseMarks = marks.stream()
                .filter(mark -> mark.getCourse().equals(course))
                .collect(Collectors.toList());

        if (courseMarks.isEmpty()) {
            markView.displayErrorMessage("No marks available for course: " + course.getName());
        } else {
            markView.displayCourseReport(course, courseMarks);
        }
    }
}
