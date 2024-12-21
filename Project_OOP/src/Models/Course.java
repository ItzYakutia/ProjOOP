package Models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseId; // Уникальный идентификатор курса
    private String name; // Название курса
    private String description; // Описание курса
    private int credits; // Количество кредитов
    private CourseType courseType; // Тип курса (Major, Minor, Free Elective)
    private School school; // Школа, к которой относится курс
    private List<Student> enrolledStudents; // Список студентов, зарегистрированных на курс
    private List<Teacher> assignedTeachers; // Список преподавателей, назначенных на курс

    public Course(String courseId, String name, String description, int credits, CourseType courseType, School school) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.courseType = courseType;
        this.school = school;
        this.enrolledStudents = new ArrayList<>();
        this.assignedTeachers = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public School getSchool() {
        return school;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Teacher> getAssignedTeachers() {
        return assignedTeachers;
    }

    // Регистрация студента на курс
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Добавление курса в список курсов студента
        } else {
            throw new IllegalArgumentException("Student is already enrolled in the course: " + name);
        }
    }

    // Удаление студента с курса
    public void unenrollStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            student.removeCourse(this); // Удаление курса из списка курсов студента
        } else {
            throw new IllegalArgumentException("Student is not enrolled in the course: " + name);
        }
    }

    // Добавление преподавателя на курс
    public void addTeacher(Teacher teacher) {
        if (!assignedTeachers.contains(teacher)) {
            assignedTeachers.add(teacher);
            teacher.addCourse(this); // Добавление курса в список курсов преподавателя
        } else {
            throw new IllegalArgumentException("Teacher is already assigned to the course: " + name);
        }
    }

    // Удаление преподавателя с курса
    public void removeTeacher(Teacher teacher) {
        if (assignedTeachers.contains(teacher)) {
            assignedTeachers.remove(teacher);
            teacher.removeCourse(this); // Удаление курса из списка курсов преподавателя
        } else {
            throw new IllegalArgumentException("Teacher is not assigned to the course: " + name);
        }
    }

    // Определение типа курса для конкретного студента
    public CourseType determineCourseTypeForStudent(Student student) {
        // Если студент из той же школы, курс считается Major или Minor
        if (student.getSpecialty().getSchool() == this.school) {
            return this.courseType;
        } else {
            // Если курс из другой школы, это Free Elective
            return CourseType.FREE_ELECTIVE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение по ссылке
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и класс
        Course course = (Course) o;
        return courseId.equals(course.courseId); // Сравнение по уникальному идентификатору
    }

    @Override
    public int hashCode() {
        return courseId.hashCode();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", courseType=" + courseType +
                ", school=" + school +
                ", enrolledStudents=" + enrolledStudents.size() +
                ", assignedTeachers=" + assignedTeachers.size() +
                '}';
    }
}
