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
 public void displayStudentSchedule(Student student) {
    System.out.println("Schedule for Student: " + student.getNameFirst() + " " + student.getNameLast());
    if (student.getSchedule().isEmpty()) {
        System.out.println("No lessons scheduled.");
    } else {
        for (Lesson lesson : student.getSchedule()) {
            displayLessonInfo(lesson);
        }
    }
}


    // Отображение расписания преподавателя
    public void displayTeacherSchedule(Teacher teacher) {
    System.out.println("Schedule for Teacher: " + teacher.getNameFirst() + " " + teacher.getNameLast());
    if (teacher.getSchedule().isEmpty()) {
        System.out.println("No lessons scheduled.");
    } else {
        for (Lesson lesson : teacher.getSchedule()) {
            displayLessonInfo(lesson);
        }
    }
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
