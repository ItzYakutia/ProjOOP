package Views;

import Models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class LessonView {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // Добавление урока
    public void addLesson(String lessonId, LessonType type, LocalDateTime dateTime, Course course, Teacher teacher, String room, List<Lesson> lessons) {
        Lesson lesson = new Lesson(lessonId, type, dateTime, course, teacher, room);
        lessons.add(lesson);
        course.addLesson(lesson);
        System.out.println("Lesson added successfully:");
        displayLessonInfo(lesson);
    }

    // Удаление урока
    public void removeLesson(String lessonId, List<Lesson> lessons) {
        Lesson lesson = findLessonById(lessonId, lessons);
        if (lesson == null) {
            System.out.println("Error: Lesson not found.");
            return;
        }
        lessons.remove(lesson);
        lesson.getCourse().removeLesson(lesson);
        System.out.println("Lesson removed successfully: Lesson ID = " + lessonId);
    }

    // Назначение преподавателя на урок
    public void assignTeacherToLesson(String lessonId, String teacherId, List<Lesson> lessons, List<Teacher> teachers) {
        Lesson lesson = findLessonById(lessonId, lessons);
        Teacher teacher = findTeacherById(teacherId, teachers);

        if (lesson == null) {
            System.out.println("Error: Lesson not found.");
            return;
        }

        if (teacher == null) {
            System.out.println("Error: Teacher not found.");
            return;
        }

        lesson.setTeacher(teacher);
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " assigned to lesson: " + lesson.getLessonId());
    }

    // Проверка посещаемости
    public void markAttendance(String lessonId, List<String> studentIds, List<Lesson> lessons, List<Student> students) {
        Lesson lesson = findLessonById(lessonId, lessons);

        if (lesson == null) {
            System.out.println("Error: Lesson not found.");
            return;
        }

        List<Student> attendingStudents = studentIds.stream()
                .map(studentId -> findStudentById(studentId, students))
                .filter(student -> student != null)
                .collect(Collectors.toList());

        System.out.println("Attendance marked for lesson: " + lesson.getLessonId());
        attendingStudents.forEach(student ->
                System.out.println("Student present: " + student.getNameFirst() + " " + student.getNameLast()));
    }

    // Получение уроков по курсу
    public void getLessonsForCourse(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);

        if (course == null) {
            System.out.println("Error: Course not found.");
            return;
        }

        List<Lesson> lessons = course.getLessons();
        System.out.println("Lessons for course " + course.getName() + ":");
        if (lessons.isEmpty()) {
            System.out.println("No lessons available.");
        } else {
            lessons.forEach(this::displayLessonInfo);
        }
    }

    // Отображение информации об уроке
    public void displayLessonInfo(Lesson lesson) {
        System.out.println("Lesson Information:");
        System.out.println("- Lesson ID: " + lesson.getLessonId());
        System.out.println("- Type: " + lesson.getType());
        System.out.println("- Date and Time: " + lesson.getDateTime().format(FORMATTER));
        System.out.println("- Course: " + lesson.getCourse().getName());
        System.out.println("- Teacher: " + (lesson.getTeacher() != null
                ? lesson.getTeacher().getNameFirst() + " " + lesson.getTeacher().getNameLast()
                : "Not assigned"));
        System.out.println("- Room: " + lesson.getRoom());
    }

    // Вспомогательные методы
    private Lesson findLessonById(String lessonId, List<Lesson> lessons) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId().equals(lessonId))
                .findFirst()
                .orElse(null);
    }

    private Teacher findTeacherById(String teacherId, List<Teacher> teachers) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentById(String studentId, List<Student> students) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String courseId, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}
