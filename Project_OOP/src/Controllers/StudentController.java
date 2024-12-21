package Controllers;

import Models.*;
import Views.StudentView;

public class StudentController {

    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    // Регистрация студента в организации
    public void joinOrganization(String organizationName) {
        try {
            student.joinOrganization(organizationName);
            studentView.displayOrganizationJoined(organizationName, student);
        } catch (IllegalArgumentException e) {
            studentView.displayError(e.getMessage());
        }
    }

    // Установление роли главы организации
    public void setAsHeadOfOrganization(boolean isHead) {
        student.setHeadOfOrganization(isHead);
        studentView.displayHeadOfOrganizationSet(student, isHead);
    }

    // Просмотр транскрипта
    public void viewTranscript() {
        studentView.displayTranscript(student);
    }

    // Просмотр информации о преподавателе
    public void viewTeacherInfo(Teacher teacher) {
        studentView.displayTeacherInfo(teacher);
    }
}
