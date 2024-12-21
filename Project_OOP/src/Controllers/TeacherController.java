package Controllers;

import Models.*;
import Views.TeacherView;

public class TeacherController {

    private final Teacher teacher;
    private final TeacherView teacherView;

    public TeacherController(Teacher teacher, TeacherView teacherView) {
        this.teacher = teacher;
        this.teacherView = teacherView;
    }

    // Отправка жалобы на студента
    public void sendComplaint(Student student, Course course, String text, UrgencyLevel urgency) {
        try {
            teacher.sendComplaint(student, course, text, urgency);
            teacherView.displayComplaintSent(student, course, text, urgency);
        } catch (IllegalArgumentException e) {
            teacherView.displayError(e.getMessage());
        }
    }

}
