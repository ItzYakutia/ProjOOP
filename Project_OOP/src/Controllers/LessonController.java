package Controllers;

import Models.*;
import Views.LessonView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LessonController {

    private final LessonView lessonView;

    public LessonController(LessonView lessonView) {
        this.lessonView = lessonView;
    }

    // Добавление урока
    public void addLesson(String lessonId, LessonType type, LocalDateTime dateTime, Course course, Teacher teacher, String room, List<Lesson> lessons) {
        if (lessons.stream().anyMatch(lesson -> lesson.getLessonId().equals(lessonId))) {
            lessonView.displayErrorMessage("Lesson already exists with ID: " + lessonId);
            return;
        }
        Lesson lesson = new Lesson(lessonId, type, dateTime, course, teacher, room);
        lessons.add(lesson);
        lessonView.displaySuccessMessage("Lesson added successfully.");
        lessonView.displayLessonInfo(lesson);
    }

    // Удаление урока
    public void removeLesson(String lessonId, List<Lesson> lessons) {
        Lesson lesson = findLessonById(lessonId, lessons);
        if (lesson == null) {
            lessonView.displayErrorMessage("Lesson not found with ID: " + lessonId);
            return;
        }
        lessons.remove(lesson);
        lessonView.displaySuccessMessage("Lesson removed successfully.");
    }

    // Назначение преподавателя на урок
    public void assignTeacherToLesson(String lessonId, Teacher teacher, List<Lesson> lessons) {
        Lesson lesson = findLessonById(lessonId, lessons);
        if (lesson == null) {
            lessonView.displayErrorMessage("Lesson not found with ID: " + lessonId);
            return;
        }
        lesson.setTeacher(teacher);
        lessonView.displaySuccessMessage("Teacher assigned successfully to lesson.");
        lessonView.displayLessonInfo(lesson);
    }

    // Получение уроков по курсу
    public void getLessonsForCourse(Course course, List<Lesson> lessons) {
        List<Lesson> courseLessons = lessons.stream()
                .filter(lesson -> lesson.getCourse().equals(course))
                .collect(Collectors.toList());

        if (courseLessons.isEmpty()) {
            lessonView.displayErrorMessage("No lessons found for course: " + course.getName());
        } else {
            lessonView.displayLessonsForCourse(course, courseLessons);
        }
    }

    // Вспомогательный метод для поиска урока
    private Lesson findLessonById(String lessonId, List<Lesson> lessons) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId().equals(lessonId))
                .findFirst()
                .orElse(null);
    }
}
