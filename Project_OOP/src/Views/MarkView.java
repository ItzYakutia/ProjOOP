package Views;

import Models.Mark;
import Models.Student;
import Models.Course;

import java.util.List;

public class MarkView {

    // Отображение информации об оценке
    public void displayMarkInfo(Mark mark) {
        if (mark == null) {
            System.out.println("Mark not found.");
            return;
        }
        System.out.println("Mark Information:");
        System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast());
        System.out.println("Course: " + mark.getCourse().getName());
        System.out.println("1st Attestation: " + mark.getAttestation1());
        System.out.println("2nd Attestation: " + mark.getAttestation2());
        System.out.println("Final Exam: " + mark.getFinalExam());
        System.out.println("Total: " + mark.getTotal());
    }

    // Отображение списка оценок
    public void displayMarkList(List<Mark> marks) {
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }
        System.out.println("List of Marks:");
        for (Mark mark : marks) {
            System.out.println("Student: " + mark.getStudent().getNameFirst() + " " + mark.getStudent().getNameLast() +
                    ", Course: " + mark.getCourse().getName() +
                    ", Total: " + mark.getTotal());
        }
    }

    // Сообщение об успешном добавлении оценки
    public void displayMarkAdded(Student student, Course course, Mark mark) {
        System.out.println("Mark added successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Course: " + course.getName() + ", Total Mark: " + mark.getTotal());
    }

    // Сообщение об успешном обновлении оценки
    public void displayMarkUpdated(Student student, Course course, Mark mark) {
        System.out.println("Mark updated successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Course: " + course.getName() + ", Total Mark: " + mark.getTotal());
    }

    // Сообщение об ошибке при добавлении или обновлении оценки
    public void displayMarkError(String errorMessage) {
        System.out.println("Error with mark operation: " + errorMessage);
    }

    // Отображение успешного удаления оценки
    public void displayMarkRemoved(Student student, Course course) {
        System.out.println("Mark removed successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Course: " + course.getName());
    }

    // Сообщение об ошибке удаления оценки
    public void displayMarkRemovalError(String errorMessage) {
        System.out.println("Error removing mark: " + errorMessage);
    }
}
