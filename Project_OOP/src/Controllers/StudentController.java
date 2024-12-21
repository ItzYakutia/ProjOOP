package Controllers;

import Models.*;
import Views.StudentView;

import java.util.List;

public class StudentController {

    private final Student student;
    private final StudentView studentView;

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

    // Регистрация студента на курс
    public void registerForCourse(Course course) {
        try {
            student.addCourse(course);
            studentView.displayCourseRegistrationSuccess(course, student);
        } catch (IllegalArgumentException e) {
            studentView.displayError(e.getMessage());
        }
    }

    // Удаление студента с курса
    public void unregisterFromCourse(Course course) {
        try {
            student.removeCourse(course);
            studentView.displayCourseUnregistrationSuccess(course, student);
        } catch (IllegalArgumentException e) {
            studentView.displayError(e.getMessage());
        }
    }

    // Просмотр транскрипта
    public void viewTranscript() {
        studentView.displayTranscript(student);
    }

    // Проверка лимита провалов (проваленные курсы > 3)
    public void checkFailLimit() {
        boolean exceeded = student.hasExceededFailLimit();
        if (exceeded) {
            studentView.displayFailLimitExceeded(student);
        } else {
            studentView.displayFailLimitOk(student);
        }
    }

    // Сортировка курсов по названию
    public void viewSortedCoursesByName() {
        List<Course> sortedCourses = student.getCoursesSortedByName();
        studentView.displaySortedCoursesByName(sortedCourses, student);
    }

    // Оценка преподавателя
    public void rateTeacher(Teacher teacher, int rating) {
        try {
            student.rateTeacher(teacher, rating);
            studentView.displayTeacherRatedSuccess(teacher, rating);
        } catch (IllegalArgumentException e) {
            studentView.displayError(e.getMessage());
        }
    }

    // Просмотр информации о преподавателе
    public void viewTeacherInfo(Teacher teacher) {
        studentView.displayTeacherInfo(teacher);
    }

    // Показ информации о студенте
    public void viewStudentInfo() {
        studentView.displayStudentInfo(student);
    }
}
