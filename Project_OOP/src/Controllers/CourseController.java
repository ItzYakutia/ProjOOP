package Controllers;

import Models.*;

import java.util.List;

public class CourseController {

    private List<Course> courses;   // Список всех курсов
    private List<Teacher> teachers; // Список всех преподавателей
    private List<Student> students; // Список всех студентов

    public CourseController(List<Course> courses, List<Teacher> teachers, List<Student> students) {
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
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

    // Назначение преподавателя на курс
    public void assignTeacherToCourse(String teacherId, String courseId) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);

        if (teacher == null || course == null) {
            System.out.println("Error: Teacher or course not found.");
            return;
        }

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

    // Регистрация студента на курс
    public void registerStudentToCourse(String studentId, String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Error: Course not found.");
            return;
        }

        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        // Проверка на лимит кредитов
        if (student.getCredits() + course.getCredits() > 21) {
            System.out.println("Error: Student cannot register for more than 21 credits.");
            return;
        }

        // Проверка на повторную регистрацию
        if (course.getStudents().contains(student)) {
            System.out.println("Error: Student " + student.getNameFirst() + " " + student.getNameLast() +
                    " is already registered for the course " + course.getName());
            return;
        }

        // Регистрация студента
        course.addStudent(student);
        student.addCourse(course);
        student.setCredits(student.getCredits() + course.getCredits());
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " successfully registered for course " + course.getName());
    }

    // Метод для проверки, разрешён ли курс для студента
    private boolean isCourseAllowedForStudent(Student student, Course course) {
        // В текущей версии этот метод можно реализовать упрощённо,
        // потому что специфика типа (Major, Minor, Free Elective) уже определяется CourseType
        return true; // Все типы курсов допустимы
    }

    // Просмотр информации о курсе
    public void viewCourseInfo(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        new CourseView().displayCourseInfo(course);
    }

    // Вспомогательные методы для поиска

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
