package Controllers;

import Models.*;
import java.util.List;

public class CourseController {

    private List<Course> courses; // Список всех курсов
    private List<Student> students; // Список всех студентов
    private List<Teacher> teachers; // Список всех преподавателей

    public CourseController(List<Course> courses, List<Student> students, List<Teacher> teachers) {
        this.courses = courses;
        this.students = students;
        this.teachers = teachers;
    }

    // Добавление нового курса с указанием типа
    public void addCourse(String courseId, String name, String description, int credits, LessonType type) {
        if (findCourseById(courseId) != null) {
            System.out.println("Course with ID " + courseId + " already exists.");
            return;
        }
        Course newCourse = new Course(courseId, name, description, credits, type);
        courses.add(newCourse);
        System.out.println("Course " + name + " added successfully.");
    }

    // Регистрация студента на курс с учетом его специальности
    public void registerStudentToCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student == null || course == null) {
            System.out.println("Student or course not found.");
            return;
        }

        if (student.getCredits() + course.getCredits() > 21) {
            System.out.println("Student cannot register for more than 21 credits.");
            return;
        }

        if (course.getType() == CourseType.MAJOR && !course.getName().contains(student.getMajor())) {
            System.out.println("Student cannot register for a major course outside their major.");
            return;
        }

        if (course.getType() == CourseType.FREE_ELECTIVE && student.getMajor().equals("SITE") && course.getName().contains("Oil and Gas")) {
            System.out.println("This major course is allowed as a free elective for SITE students.");
        }

        course.addStudent(student);
        student.addCourse(course);
        student.setCredits(student.getCredits() + course.getCredits());
        System.out.println("Student " + student.getNameFirst() + " registered to course " + course.getName() + ".");
    }

    // Назначение нескольких преподавателей на курс
    public void assignInstructorsToCourse(String courseId, List<String> teacherIds) {
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        for (String teacherId : teacherIds) {
            Teacher teacher = findTeacherById(teacherId);
            if (teacher != null) {
                course.addInstructor(teacher);
                teacher.getCourses().add(course);
                System.out.println("Teacher " + teacher.getNameFirst() + " assigned to course " + course.getName() + ".");
            } else {
                System.out.println("Teacher with ID " + teacherId + " not found.");
            }
        }
    }

    // Генерация отчета об успеваемости для курса
    public void generateCourseReport(String courseId) {
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Performance Report for Course: " + course.getName());
        for (Student student : course.getStudents()) {
            Mark mark = student.getTranscript().get(course);
            if (mark != null) {
                System.out.println("Student: " + student.getNameFirst() + " " + student.getNameLast() +
                        ", Total Mark: " + mark.getTotal());
            } else {
                System.out.println("Student: " + student.getNameFirst() + " " + student.getNameLast() +
                        " has no marks yet.");
            }
        }
    }

    // Получение списка всех курсов по типу
    public List<Course> getCoursesByType(LessonType type) {
        return courses.stream()
                .filter(course -> course.getType() == type)
                .toList();
    }

    // Вспомогательные методы для поиска курсов, студентов и преподавателей
    private Course findCourseById(String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
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
