package Controllers;

import Models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class LessonController {
    private List<Lesson> lessons;

    public LessonController() {
        this.lessons = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        System.out.println("Lesson added: " + lesson.getLessonId());
    }

    public void removeLesson(String lessonId) {
        boolean removed = lessons.removeIf(l -> l.getLessonId().equals(lessonId));
        if (removed) {
            System.out.println("Lesson removed with ID: " + lessonId);
        } else {
            System.out.println("Lesson not found with ID: " + lessonId);
        }
    }

    public void listLessons() {
        System.out.println("Listing all lessons:");
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }
}
