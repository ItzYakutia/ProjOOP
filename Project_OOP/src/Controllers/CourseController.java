package Controllers;

import Models.*;

import java.util.List;

public class CourseController {

    private List<Course> courses;
    private List<Teacher> teachers;

    public CourseController(List<Course> courses, List<Teacher> teachers) {
        this.courses = courses;
        this.teachers = teachers;
    }

    // Назначение преподавателя на курс
    public void assignTeacherToCourse(String teacherId, String courseId) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);

        if (teacher == null || course == null) {
            System.out.println("Error: Teacher or course not found.");
            return;
        }

        // Проверка, что преподаватель уже назначен на этот курс
        if (course.getTeachers().contains(teacher)) {
            System.out.println("Error: Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                    " is already assigned to the course " + course.getName());
            return;
        }

        course.addTeacher(teacher);
        teacher.addCourse(course);
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " successfully assigned to course " + course.getName());
    }

    // Добавление нового курса
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("Error: Course " + course.getName() + " already exists.");
            return;
        }
        courses.add(course);
        System.out.println("Course " + course.getName() + " added successfully.");
    }

    // Удаление курса
    public void removeCourse(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Error: Course not found.");
            return;
        }
        courses.remove(course);
        System.out.println("Course " + course.getName() + " removed successfully.");
    }

    // Просмотр информации о курсе
    public void viewCourseInfo(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Course Information:");
        System.out.println("- Name: " + course.getName());
        System.out.println("- Description: " + course.getDescription());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Teachers: ");
        for (Teacher teacher : course.getTeachers()) {
            System.out.println("  * " + teacher.getNameFirst() + " " + teacher.getNameLast() + " (" + teacher.getTitle() + ")");
        }
        System.out.println("- Students: ");
        for (Student student : course.getStudents()) {
            System.out.println("  * " + student.getNameFirst() + " " + student.getNameLast() + " (ID: " + student.getUserId() + ")");
        }
    }

    // Вспомогательные методы для поиска курса и преподавателя
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
}
