package Views;

import Models.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseView {

    // Сортировка курсов по названию
    public void displaySortedCoursesByName(List<Course> courses) {
        List<Course> sortedCourses = courses.stream()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toList());

        System.out.println("Courses sorted by name:");
        for (Course course : sortedCourses) {
            System.out.println("- " + course.getName() + " (" + course.getCredits() + " credits)");
        }
    }

    // Сортировка курсов по количеству студентов
    public void displaySortedCoursesByStudentCount(List<Course> courses) {
        List<Course> sortedCourses = courses.stream()
                .sorted(Comparator.comparingInt(course -> ((Course) course).getStudents().size()).reversed())
                .collect(Collectors.toList());

        System.out.println("Courses sorted by student count:");
        for (Course course : sortedCourses) {
            System.out.println("- " + course.getName() + " (" + course.getStudents().size() + " students)");
        }
    }

    // Добавление нового курса
    public void addCourse(Course course, List<Course> courses) {
        if (courses.contains(course)) {
            System.out.println("Error: Course " + course.getName() + " already exists.");
            return;
        }
        courses.add(course);
        System.out.println("Course " + course.getName() + " added successfully.");
    }

    // Удаление курса
    public void removeCourse(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            System.out.println("Error: Course not found.");
            return;
        }
        courses.remove(course);
        System.out.println("Course " + course.getName() + " removed successfully.");
    }

    // Назначение преподавателя на курс
    public void assignTeacherToCourse(String teacherId, String courseId, List<Course> courses, List<Teacher> teachers) {
        Course course = findCourseById(courseId, courses);
        Teacher teacher = findTeacherById(teacherId, teachers);

        if (course == null || teacher == null) {
            System.out.println("Error: Course or teacher not found.");
            return;
        }

        if (course.getTeachers().contains(teacher)) {
            System.out.println("Error: Teacher is already assigned to the course.");
            return;
        }

        course.addTeacher(teacher);
        teacher.addCourse(course);
        System.out.println("Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " assigned to course " + course.getName());
    }

    // Регистрация студента на курс
    public void registerStudentToCourse(String studentId, String courseId, List<Course> courses, List<Student> students) {
        Course course = findCourseById(courseId, courses);
        Student student = findStudentById(studentId, students);

        if (course == null || student == null) {
            System.out.println("Error: Course or student not found.");
            return;
        }

        if (student.getCredits() + course.getCredits() > 21) {
            System.out.println("Error: Student cannot register for more than 21 credits.");
            return;
        }

        if (course.getStudents().contains(student)) {
            System.out.println("Error: Student is already registered for this course.");
            return;
        }

        course.addStudent(student);
        student.addCourse(course);
        student.setCredits(student.getCredits() + course.getCredits());
        System.out.println("Student " + student.getNameFirst() + " " + student.getNameLast() +
                " successfully registered for course " + course.getName());
    }

    // Просмотр информации о курсе
    public void displayCourseInfo(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            System.out.println("Error: Course not found.");
            return;
        }

        System.out.println("Course Information:");
        System.out.println("- Name: " + course.getName());
        System.out.println("- Description: " + course.getDescription());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Enrolled Students: " + course.getStudents().size());
        System.out.println("- Assigned Teachers: " + course.getTeachers().size());
    }

    // Вспомогательные методы
    private Course findCourseById(String courseId, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
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
}
