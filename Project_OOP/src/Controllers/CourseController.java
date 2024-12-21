package Controllers;

import Models.*;
import Views.CourseView;

import java.util.Comparator;
import java.util.List;

public class CourseController {

    private final CourseView courseView;

    public CourseController(CourseView courseView) {
        this.courseView = courseView;
    }

    // Добавление курса
    public void addCourse(Course course, List<Course> courses) {
        if (courses.contains(course)) {
            courseView.displayErrorMessage("Course already exists: " + course.getName());
        } else {
            courses.add(course);
            courseView.displaySuccessMessage("Course added successfully: " + course.getName());
        }
    }

    // Удаление курса
    public void removeCourse(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else {
            courses.remove(course);
            courseView.displaySuccessMessage("Course removed successfully: " + course.getName());
        }
    }

    // Назначение преподавателя на курс
    public void assignTeacherToCourse(Teacher teacher, String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else if (!course.addTeacher(teacher)) { // Метод добавления учителя в Course
            courseView.displayErrorMessage("Teacher is already assigned to the course.");
        } else {
            courseView.displaySuccessMessage("Teacher assigned to course: " + teacher.getNameFirst() + " " + teacher.getNameLast());
        }
    }

    // Удаление преподавателя с курса
    public void removeTeacherFromCourse(Teacher teacher, String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else if (!course.removeTeacher(teacher)) { // Метод удаления учителя из Course
            courseView.displayErrorMessage("Teacher is not assigned to the course.");
        } else {
            courseView.displaySuccessMessage("Teacher removed from course: " + teacher.getNameFirst() + " " + teacher.getNameLast());
        }
    }

    // Регистрация студента на курс
    public void registerStudentToCourse(Student student, String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else if (!course.addStudent(student)) { // Метод добавления студента в Course
            courseView.displayErrorMessage("Student is already registered for this course.");
        } else {
            courseView.displaySuccessMessage("Student registered to course: " + student.getNameFirst() + " " + student.getNameLast());
        }
    }

    // Удаление студента с курса
    public void unregisterStudentFromCourse(Student student, String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else if (!course.removeStudent(student)) { // Метод удаления студента из Course
            courseView.displayErrorMessage("Student is not registered for this course.");
        } else {
            courseView.displaySuccessMessage("Student removed from course: " + student.getNameFirst() + " " + student.getNameLast());
        }
    }

    // Сортировка студентов по имени
    public void sortStudentsByName(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else {
            List<Student> sortedStudents = course.getStudents().stream()
                    .sorted(Comparator.comparing(Student::getNameFirst)
                            .thenComparing(Student::getNameLast))
                    .toList();
            courseView.displaySortedStudents(sortedStudents, "name");
        }
    }

    // Сортировка студентов по GPA
    public void sortStudentsByGPA(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else {
            List<Student> sortedStudents = course.getStudents().stream()
                    .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                    .toList();
            courseView.displaySortedStudents(sortedStudents, "GPA");
        }
    }

    // Сортировка курсов по количеству студентов
    public void sortCoursesByStudentCount(List<Course> courses) {
        List<Course> sortedCourses = courses.stream()
                .sorted(Comparator.comparingInt(course -> course.getStudents().size()).reversed())
                .toList();
        courseView.displaySortedCourses(sortedCourses, "student count");
    }

    // Просмотр информации о курсе
    public void viewCourseInfo(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            courseView.displayErrorMessage("Course not found.");
        } else {
            courseView.displayCourseInfo(course);
        }
    }

    // Вспомогательный метод для поиска курса
    private Course findCourseById(String courseId, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}
