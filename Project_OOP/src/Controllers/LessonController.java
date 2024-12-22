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
    public void addLesson(String lessonId, LessonType type, LocalDateTime startTime, LocalDateTime endTime, 
                          String room, Teacher teacher, Course course, List<Lesson> lessons) {
        Lesson newLesson = new Lesson(lessonId, type, startTime, endTime, course, teacher, room);
        // Проверяем пересечения с уже существующими уроками
        for (Lesson existingLesson : lessons) {
            if (newLesson.isOverlapping(existingLesson)) {
                lessonView.displayErrorMessage("Lesson overlaps with an existing lesson in room: " + room);
                return;
            }
        }
        lessons.add(newLesson);
        teacher.addLessonToSchedule(newLesson); // Добавляем урок в расписание преподавателя

    // Добавляем урок в расписание каждого студента, зарегистрированного на курс
    for (Student student : course.getEnrolledStudents()) {
        student.addLessonToSchedule(newLesson);
    }

        lessonView.displaySuccessMessage("Lesson added successfully for course: " + course.getName());
        
    }
    
    //удаление урока
    public void removeLesson(String lessonId, List<Lesson> lessons) {
    Lesson lessonToRemove = findLessonById(lessonId, lessons);

    if (lessonToRemove == null) {
        lessonView.displayErrorMessage("Lesson not found.");
        return;
    }

    lessons.remove(lessonToRemove);
    lessonToRemove.getTeacher().removeLessonFromSchedule(lessonToRemove); // Удаляем из расписания преподавателя

    // Удаляем урок из расписаний студентов
    for (Student student : lessonToRemove.getCourse().getEnrolledStudents()) {
        student.removeLessonFromSchedule(lessonToRemove);
    }

    lessonView.displaySuccessMessage("Lesson removed successfully: " + lessonToRemove.getLessonId());
}


    // Просмотр расписания студента
    public void viewStudentSchedule(Student student, List<Lesson> lessons) {
        lessonView.displayStudentSchedule(student, lessons);
    }

    // Просмотр расписания преподавателя
    public void viewTeacherSchedule(Teacher teacher, List<Lesson> lessons) {
        lessonView.displayTeacherSchedule(teacher, lessons);
    }

    // Вспомогательный метод для поиска урока по ID
    private Lesson findLessonById(String lessonId, List<Lesson> lessons) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId().equals(lessonId))
                .findFirst()
                .orElse(null);
    }
}
