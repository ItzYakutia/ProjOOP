package Views;

import Models.*;

import java.util.List;

public class LessonView {

    // Отображение сообщения об успехе
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Отображение сообщения об ошибке
    public void displayErrorMessage(String message) {
        System.err.println("ERROR: " + message);
    }

    // Отображение информации об уроке
    public void displayLessonInfo(Lesson lesson) {
        System.out.println("Lesson Information:");
        System.out.println("- Lesson ID: " + lesson.getLessonId());
        System.out.println("- Type: " + lesson.getType());
        System.out.println("- Date and Time: " + lesson.getDateTime());
        System.out.println("- Course: " + lesson.getCourse().getName());
        System.out.println("- Teacher: " + (lesson.getTeacher() != null
                ? lesson.getTeacher().getNameFirst() + " " + lesson.getTeacher().getNameLast()
                : "Not assigned"));
        System.out.println("- Room: " + lesson.getRoom());
    }

    // Отображение уроков для курса
    public void displayLessonsForCourse(Course course, List<Lesson> lessons) {
        System.out.println("Lessons for Course: " + course.getName());
        for (Lesson lesson : lessons) {
            displayLessonInfo(lesson);
        }
    }
}
