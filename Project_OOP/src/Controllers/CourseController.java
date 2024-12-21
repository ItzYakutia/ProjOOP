package Controllers;

import Models.*;
import Views.CourseView;

import java.util.List;

public class CourseController {

    private final CourseView courseView;

    public CourseController(CourseView courseView) {
        this.courseView = courseView;
    }

    // Сортировка курсов по названию
    public void sortCoursesByName(List<Course> courses) {
        courseView.displaySortedCoursesByName(courses);
    }

    // Сортировка курсов по количеству студентов
    public void sortCoursesByStudentCount(List<Course> courses) {
        courseView.displaySortedCoursesByStudentCount(courses);
    }

    // Добавление нового курса
    public void addCourse(Course course, List<Course> courses) {
        courseView.addCourse(course, courses);
    }

    // Удаление курса
    public void removeCourse(String courseId, List<Course> courses) {
        courseView.removeCourse(courseId, courses);
    }

    // Назначение преподавателя на курс
    public void assignTeacherToCourse(String teacherId, String courseId, List<Course> courses, List<Teacher> teachers) {
        courseView.assignTeacherToCourse(teacherId, courseId, courses, teachers);
    }

    // Регистрация студента на курс
    public void registerStudentToCourse(String studentId, String courseId, List<Course> courses, List<Student> students) {
        courseView.registerStudentToCourse(studentId, courseId, courses, students);
    }

    // Просмотр информации о курсе
    public void viewCourseInfo(String courseId, List<Course> courses) {
        courseView.displayCourseInfo(courseId, courses);
    }
}
