package Views;

import Models.*;

import java.util.List;

public class CourseView {

    // Отображение успешного добавления курса
    public void displayCourseAdded(Course course) {
        System.out.println("Course added successfully: " + course.getName() + " (" + course.getCourseId() + ")");
    }

    // Отображение ошибки при добавлении курса
    public void displayCourseAdditionError(String errorMessage) {
        System.out.println("Error adding course: " + errorMessage);
    }

    // Отображение успешного удаления курса
    public void displayCourseRemoved(Course course) {
        System.out.println("Course removed successfully: " + course.getName() + " (" + course.getCourseId() + ")");
    }

    // Отображение ошибки при удалении курса
    public void displayCourseRemovalError(String errorMessage) {
        System.out.println("Error removing course: " + errorMessage);
    }

    // Отображение информации о курсе
    public void displayCourseInfo(Course course) {
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Course Information:");
        System.out.println("- Name: " + course.getName());
        System.out.println("- ID: " + course.getCourseId());
        System.out.println("- Description: " + course.getDescription());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Course Type: " + course.getCourseType());
        System.out.println("- Teachers:");
        for (Teacher teacher : course.getTeachers()) {
            System.out.println("  * " + teacher.getNameFirst() + " " + teacher.getNameLast() + " (" + teacher.getTitle() + ")");
        }
        System.out.println("- Students:");
        for (Student student : course.getStudents()) {
            System.out.println("  * " + student.getNameFirst() + " " + student.getNameLast() + " (ID: " + student.getUserId() + ")");
        }
    }

    // Отображение списка всех курсов
    public void displayAllCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName() + " (" + course.getCourseId() + ")");
        }
    }

    // Отображение успешного назначения преподавателя на курс
    public void displayTeacherAssigned(Teacher teacher, Course course) {
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " successfully assigned to course " + course.getName());
    }

    // Отображение ошибки при назначении преподавателя
    public void displayTeacherAssignmentError(String errorMessage) {
        System.out.println("Error assigning teacher: " + errorMessage);
    }
}
