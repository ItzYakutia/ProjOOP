package Controllers;

import Models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LessonController {

    private List<Lesson> lessons; // Список всех уроков
    private List<Course> courses; // Список всех курсов
    private List<Teacher> teachers; // Список всех преподавателей
    private List<Student> students; // Список всех студентов

    public LessonController(List<Lesson> lessons, List<Course> courses, List<Teacher> teachers, List<Student> students) {
        this.lessons = lessons;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    // Добавление нового урока
    public void addLesson(String lessonId, LessonType type, LocalDateTime dateTime, Course course, Teacher teacher, String room) {
        Course course1 = findCourseById(lessonId);

        if (course1 == null) {
            System.out.println("Course not found.");
            return;
        }

        Lesson lesson = new Lesson(lessonId, type, dateTime, course1, teacher, room);
        lessons.add(lesson);
        course1.addLesson(lesson);
        System.out.println("Lesson added successfully for course: " + course1.getName());
    }

    // Удаление урока
    public void removeLesson(String lessonId) {
        Lesson lesson = findLessonById(lessonId);

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        lessons.remove(lesson);
        lesson.getCourse().removeLesson(lesson);
        System.out.println("Lesson removed successfully.");
    }

    // Назначение преподавателя на урок
    public void assignTeacherToLesson(String lessonId, String teacherId) {
        Lesson lesson = findLessonById(lessonId);
        Teacher teacher = findTeacherById(teacherId);

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        lesson.setTeacher(teacher);
        System.out.println("Teacher " + teacher.getNameFirst() + " assigned to lesson: " + lesson.getTopic());
    }

    // Проверка посещаемости студентов на уроке
    public void markAttendance(String lessonId, List<String> studentIds) {
        Lesson lesson = findLessonById(lessonId);

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        List<Student> attendingStudents = studentIds.stream()
                .map(this::findStudentById)
                .filter(student -> student != null)
                .collect(Collectors.toList());

        System.out.println("Attendance marked for lesson: " + lesson.getTopic());
        attendingStudents.forEach(student ->
                System.out.println("Student present: " + student.getNameFirst() + " " + student.getNameLast()));
    }

    // Получение всех уроков для курса
    public List<Lesson> getLessonsForCourse(String courseId) {
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return new ArrayList<>();
        }

        return course.getLessons();
    }

    // Вспомогательные методы для поиска уроков, курсов, преподавателей и студентов
    private Lesson findLessonById(String lessonId) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId().equals(lessonId))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    private Teacher findTeacherById(String teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }
}
