package Views;

import Models.*;

import java.util.List;

public class LessonView {

    // Вывод сообщения об успешном добавлении/удалении урока
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Вывод сообщения об ошибке
    public void displayErrorMessage(String message) {
        System.out.println("ERROR: " + message);
    }

    // Отображение расписания студента
    public void displayStudentSchedule(Student student, List<Lesson> lessons) {
        System.out.println("Schedule for Student: " + student.getNameFirst() + " " + student.getNameLast());
        lessons.stream()
                .filter(lesson -> lesson.getCourse().getEnrolledStudents().contains(student))
                .forEach(this::displayLessonInfo);
    }

    // Отображение расписания преподавателя
    public void displayTeacherSchedule(Teacher teacher, List<Lesson> lessons) {
        System.out.println("Schedule for Teacher: " + teacher.getNameFirst() + " " + teacher.getNameLast());
        lessons.stream()
                .filter(lesson -> lesson.getTeacher().equals(teacher))
                .forEach(this::displayLessonInfo);
    }

    // Вывод информации об уроке
    public void displayLessonInfo(Lesson lesson) {
        System.out.println("Lesson ID: " + lesson.getLessonId());
        System.out.println("Course: " + lesson.getCourse().getName());
        System.out.println("Type: " + lesson.getType());
        System.out.println("Time: " + lesson.getStartTime() + " - " + lesson.getEndTime());
        System.out.println("Room: " + lesson.getRoom());
        System.out.println("Teacher: " + lesson.getTeacher().getNameLast() + " " + lesson.getTeacher().getNameFirst().charAt(0) + ".");
        System.out.println("---------------");
    }
}
