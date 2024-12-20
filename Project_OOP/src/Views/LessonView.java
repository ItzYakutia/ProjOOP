package Views;

import Models.Lesson;
import Models.LessonType;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class LessonView {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // Отображение информации об уроке
    public void displayLessonInfo(Lesson lesson) {
        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }
        System.out.println("Lesson Information:");
        System.out.println("Lesson ID: " + lesson.getLessonId());
        System.out.println("Type: " + lesson.getType());
        System.out.println("Date and Time: " + lesson.getDateTime().format(FORMATTER));
        System.out.println("Course: " + lesson.getCourse().getName());
        System.out.println("Teacher: " + (lesson.getTeacher() != null
                ? lesson.getTeacher().getNameFirst() + " " + lesson.getTeacher().getNameLast()
                : "Not assigned"));
        System.out.println("Room: " + lesson.getRoom());
    }

    // Отображение списка уроков
    public void displayLessonList(List<Lesson> lessons) {
        if (lessons.isEmpty()) {
            System.out.println("No lessons available.");
            return;
        }
        System.out.println("List of Lessons:");
        for (Lesson lesson : lessons) {
            System.out.println("- Lesson ID: " + lesson.getLessonId() +
                    ", Type: " + lesson.getType() +
                    ", Date and Time: " + lesson.getDateTime().format(FORMATTER) +
                    ", Room: " + lesson.getRoom());
        }
    }

    // Сообщение об успешном добавлении урока
    public void displayLessonAdded(Lesson lesson) {
        System.out.println("Lesson added successfully:");
        displayLessonInfo(lesson);
    }

    // Сообщение об ошибке добавления урока
    public void displayLessonAdditionError(String errorMessage) {
        System.out.println("Error adding lesson: " + errorMessage);
    }

    // Сообщение об успешном удалении урока
    public void displayLessonRemoved(String lessonId) {
        System.out.println("Lesson removed successfully: Lesson ID = " + lessonId);
    }

    // Сообщение об ошибке удаления урока
    public void displayLessonRemovalError(String errorMessage) {
        System.out.println("Error removing lesson: " + errorMessage);
    }

    // Сообщение об успешном назначении преподавателя
    public void displayTeacherAssigned(String lessonId, String teacherName) {
        System.out.println("Teacher " + teacherName + " assigned successfully to Lesson ID: " + lessonId);
    }

    // Сообщение об ошибке назначения преподавателя
    public void displayTeacherAssignmentError(String errorMessage) {
        System.out.println("Error assigning teacher: " + errorMessage);
    }

    // Сообщение об успешной отметке посещаемости
    public void displayAttendanceMarked(String lessonId) {
        System.out.println("Attendance marked successfully for Lesson ID: " + lessonId);
    }

    // Сообщение об ошибке отметки посещаемости
    public void displayAttendanceError(String errorMessage) {
        System.out.println("Error marking attendance: " + errorMessage);
    }
}
