package Models;

public class Lesson {
    private String lessonId;
    private LessonType type;
    private Course course;

    public Lesson(String lessonId, LessonType type, Course course) {
        this.lessonId = lessonId;
        this.type = type;
        this.course = course;
    }

    public String getLessonId() { return lessonId; }
    public LessonType getType() { return type; }

    @Override
    public String toString() {
        return "Lesson{" + "lessonId='" + lessonId + '\'' + ", type=" + type + ", course=" + course + '}';
    }
}
