import java.util.List;

public class AttendanceController {
    private final AttendanceView attendanceView;

    public AttendanceController(AttendanceView attendanceView) {
        this.attendanceView = attendanceView;
    }

    // Student confirms attendance
    public void confirmAttendance(Student student, Lesson lesson) {
        try {
            student.confirmAttendance(lesson);
            attendanceView.displayAttendanceConfirmed(student, lesson);
        } catch (IllegalStateException | IllegalArgumentException e) {
            attendanceView.displayError(e.getMessage());
        }
    }

    // Teacher marks attendance manually
    public void markAttendance(Teacher teacher, Lesson lesson, Student student) {
        try {
            teacher.markAttendance(lesson, student);
            attendanceView.displayAttendanceManuallyMarked(teacher, lesson, student);
        } catch (IllegalArgumentException e) {
            attendanceView.displayError(e.getMessage());
        }
    }

    // View attendance report
    public void viewAttendanceReport(Teacher teacher, Lesson lesson) {
        if (!lesson.getTeacher().equals(teacher)) {
            attendanceView.displayError("You are not assigned to this lesson.");
            return;
        }
        attendanceView.displayAttendanceReport(lesson);
    }
}
