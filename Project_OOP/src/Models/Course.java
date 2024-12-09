package Models;

import java.util.List;

public class Course {

    private String courseId; // Уникальный идентификатор курса
    private String name; // Название курса
    private String description; // Описание курса
    private int credits; // Количество кредитов за курс
    private List<Teacher> instructors; // Преподаватели, ведущие курс
    private List<Student> students; // Студенты, зарегистрированные на курс
    private List<Lesson> lessons; // Занятия в рамках курса

    public Course(String courseId, String name, String description, int credits,
                  List<Teacher> instructors, List<Student> students, List<Lesson> lessons) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.instructors = instructors;
        this.students = students;
        this.lessons = lessons;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1 || credits > 10) {
            throw new IllegalArgumentException("Credits must be between 1 and 10");
        }
        this.credits = credits;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Teacher> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", instructors=" + instructors +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
