package Models;

import java.time.LocalDateTime;

public class Lesson {

    private String lessonId; // Уникальный идентификатор занятия
    private LessonType type; // Тип занятия (например, Лекция или Практика)
    private LocalDateTime dateTime; // Дата и время занятия
    private Course course; // Курс, к которому относится занятие
    private Teacher teacher; // Преподаватель, проводящий занятие
    private String room; // Аудитория для занятия

    public Lesson(String lessonId, LessonType type, LocalDateTime dateTime, Course course, Teacher teacher, String room) {
        this.lessonId = lessonId;
        this.type = type;
        this.dateTime = dateTime;
        this.course = course;
        this.teacher = teacher;
        this.room = room;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId='" + lessonId + '\'' +
                ", type=" + type +
                ", dateTime=" + dateTime +
                ", course=" + course +
                ", teacher=" + teacher +
                ", room='" + room + '\'' +
                '}';
    }
}
