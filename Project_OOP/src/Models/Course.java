package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private String courseId; // Уникальный идентификатор курса
    private String name; // Название курса
    private String description; // Описание курса
    private int credits; // Количество кредитов
    private CourseType courseType; // Тип курса (Major, Minor, Free Elective)
    private List<Student> students; // Список студентов
    private List<Teacher> teachers; // Список преподавателей

    public Course(String courseId, String name, String description, int credits, CourseType courseType) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.courseType = courseType;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    // Геттеры
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

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    // Добавление студента
    public boolean addStudent(Student student) {
        if (students.contains(student)) {
            return false; // Студент уже зарегистрирован
        }
        students.add(student);
        return true;
    }

    // Добавление преподавателя
    public boolean addTeacher(Teacher teacher) {
        if (teachers.contains(teacher)) {
            return false; // Преподаватель уже назначен
        }
        teachers.add(teacher);
        return true;
    }

    // Удаление студента
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    // Удаление преподавателя
    public boolean removeTeacher(Teacher teacher) {
        return teachers.remove(teacher);
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", students=" + students.size() +
                ", teachers=" + teachers.size() +
                '}';
    }
}
