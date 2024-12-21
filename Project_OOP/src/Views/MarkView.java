package Views;

import Models.*;

import java.util.List;

public class MarkView {

    // Отображение сообщения об успехе
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Отображение сообщения об ошибке
    public void displayErrorMessage(String message) {
        System.err.println("ERROR: " + message);
    }

    // Отображение транскрипта студента
    public void displayTranscript(Student student, List<Mark> marks) {
        System.out.println("Transcript for: " + student.getNameFirst() + " " + student.getNameLast());
        for (Mark mark : marks) {
            System.out.println("Course: " + mark.getCourse().getName() + ", Total Mark: " + mark.getTotal());
        }
    }

    // Отображение отчёта о курсе
    public void displayCourseReport(Course course, List<Mark> marks) {
        System.out.println("Course Report: " + course.getName());
        for (Mark mark : marks) {
            System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                    ", Total Mark: " + mark.getTotal());
        }
    }
}
