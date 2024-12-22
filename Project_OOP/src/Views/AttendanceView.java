public class AttendanceView {

    public void displayAttendanceConfirmed(Student student, Lesson lesson) {
        System.out.println("Attendance confirmed for student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Lesson: " + lesson.getLessonId());
    }

    public void displayAttendanceManuallyMarked(Teacher teacher, Lesson lesson, Student student) {
        System.out.println("Attendance manually marked by teacher: " + teacher.getNameFirst() + " " + teacher.getNameLast());
        System.out.println("Student: " + student.getNameFirst() + " " + student.getNameLast());
        System.out.println("Lesson: " + lesson.getLessonId());
    }

    public void displayAttendanceReport(Lesson lesson) {
        System.out.println("Attendance Report for Lesson: " + lesson.getLessonId());
        System.out.println("Course: " + lesson.getCourse().getName());
        System.out.println("Teacher: " + lesson.getTeacher().getNameFirst() + " " + lesson.getTeacher().getNameLast());
        System.out.println("Room: " + lesson.getRoom());
        System.out.println("Present Students:");
        for (Student student : lesson.getPresentStudents()) {
            System.out.println("- " + student.getNameFirst() + " " + student.getNameLast());
        }
    }

    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }
}
