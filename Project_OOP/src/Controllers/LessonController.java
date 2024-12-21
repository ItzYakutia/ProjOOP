package Controllers;

import Models.*;
import Views.LessonView;

import java.time.LocalDateTime;
import java.util.List;

public class LessonController {

    private final LessonView lessonView;

    public LessonController(LessonView lessonView) {
        this.lessonView = lessonView;
    }

    // Добавление урока
    public void addLesson(String lessonId, LessonType type, LocalDateTime dateTime, Course course, Teacher teacher, String room, List<Lesson> lessons) {
        lessonView.addLesson(lessonId, type, dateTime, course, teacher, room, lessons);
    }

    // Удаление урока
    public void removeLesson(String lessonId, List<Lesson> lessons) {
        lessonView.removeLesson(lessonId, lessons);
    }

    // Назначение преподавателя на урок
    public void assignTeacherToLesson(String lessonId, String teacherId, List<Lesson> lessons, List<Teacher> teachers) {
        lessonView.assignTeacherToLesson(lessonId, teacherId, lessons, teachers);
    }

    // Проверка посещаемости
    public void markAttendance(String lessonId, List<String> studentIds, List<Lesson> lessons, List<Student> students) {
        lessonView.markAttendance(lessonId, studentIds, lessons, students);
    }

    // Получение уроков по курсу
    public void getLessonsForCourse(String courseId, List<Course> courses) {
        lessonView.getLessonsForCourse(courseId, courses);
    }
}
