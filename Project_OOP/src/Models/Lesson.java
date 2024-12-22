package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lesson {

    private String lessonId; // Уникальный идентификатор занятия
    private LessonType type; // Тип занятия (например, Лекция или Практика)
    private LocalDateTime startTime; // Время начала занятия
    private LocalDateTime endTime;   // Время окончания занятия
    private Course course; // Курс, к которому относится занятие
    private Teacher teacher; // Преподаватель, проводящий занятие
    private String room; // Аудитория для занятия
    private Map<Student, Boolean> attendanceMap; // Tracks attendance for each student
    

    // Конструктор
    public Lesson(String lessonId, LessonType type, LocalDateTime startTime, LocalDateTime endTime, Course course, Teacher teacher, String room) {
        this.lessonId = lessonId;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
        this.teacher = teacher;
        this.room = room;
        this.attendanceMap = new HashMap<>();

        validateLessonTime();
    }

    // Геттеры и сеттеры
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        validateLessonTime();
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        validateLessonTime();
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
    public Map<Student, Boolean> getAttendanceMap() {
        return attendanceMap;
    }
    
//attendance 
     public boolean isAttendanceWindowOpen() {
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(startTime) && !now.isAfter(endTime);
    }

    public void addStudentToAttendance(Student student) {
        attendanceMap.put(student, false); // Initially, the student is not marked as present
    }

    
    public void confirmAttendance(Student student) {
        if (!isAttendanceWindowOpen()) {
            throw new IllegalStateException("Attendance window is closed for this lesson.");
        }
        if (!attendanceMap.containsKey(student)) {
            throw new IllegalArgumentException("Student is not registered for this lesson.");
        }
        attendanceMap.put(student, true); // Mark the student as present
    }


    public List<Student> getPresentStudents() {
        List<Student> presentStudents = new ArrayList<>();
        for (Map.Entry<Student, Boolean> entry : attendanceMap.entrySet()) {
            if (entry.getValue()) {
                presentStudents.add(entry.getKey());
            }
        }
        return presentStudents;
    }
}

    
    // Проверка времени урока (начало должно быть до окончания)
    private void validateLessonTime() {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Lesson start time must be before end time.");
        }
    }

    // Проверка пересечения времени с другим уроком
    public boolean isOverlapping(Lesson otherLesson) {
        return this.room.equals(otherLesson.room) && // Один и тот же кабинет
                this.startTime.isBefore(otherLesson.endTime) &&
                this.endTime.isAfter(otherLesson.startTime);
    }

    // Метод для форматирования даты и времени
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return startTime.format(formatter) + " - " + endTime.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonId.equals(lesson.lessonId);
    }

    @Override
    public int hashCode() {
        return lessonId.hashCode();
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId='" + lessonId + '\'' +
                ", type=" + type +
                ", time=" + getFormattedTime() +
                ", course=" + course.getName() +
                ", teacher=" + teacher.getNameLast() + " " + teacher.getNameFirst().charAt(0) + "." +
                ", room='" + room + '\'' +
                '}';
    }
}
