package Controllers;

import Models.*;
import Views.TeacherView;

import java.util.List;

public class TeacherController {

    private final TeacherView teacherView;

    public TeacherController(TeacherView teacherView) {
        this.teacherView = teacherView;
    }

    // Сортировка преподавателей по фамилии (алфавитно)
    public void sortTeachersByLastName(List<Teacher> teachers) {
        teacherView.displaySortedTeachersByLastName(teachers);
    }

    // Просмотр курсов преподавателя
    public void viewCourses(String teacherId, List<Teacher> teachers) {
        teacherView.displayTeacherCourses(teacherId, teachers);
    }

    // Управление курсами (добавление/удаление студентов)
    public void manageCourse(String teacherId, String courseId, String studentId, boolean isAdd, 
                             List<Teacher> teachers, List<Course> courses, List<Student> students) {
        teacherView.manageCourse(teacherId, courseId, studentId, isAdd, teachers, courses, students);
    }

    // Просмотр студентов и их информации на курсе
    public void viewStudents(String courseId, List<Course> courses) {
        teacherView.displayStudentsInCourse(courseId, courses);
    }

    // Выставление оценок
    public void putMarks(String teacherId, String studentId, String courseId, double attestation1, 
                         double attestation2, double finalExam, List<Teacher> teachers, 
                         List<Course> courses, List<Student> students) {
        teacherView.putMarks(teacherId, studentId, courseId, attestation1, attestation2, finalExam, teachers, courses, students);
    }

    // Отправка сообщений другим сотрудникам
    public void sendMessage(String teacherId, String recipientId, String messageText, List<Teacher> teachers, List<Employee> employees) {
        teacherView.sendMessage(teacherId, recipientId, messageText, teachers, employees);
    }

    // Отправка жалоб на студента
    public void sendComplaint(String teacherId, String studentId, String courseId, String text, UrgencyLevel urgency, 
                              List<Teacher> teachers, List<Student> students, List<Course> courses) {
        teacherView.sendComplaint(teacherId, studentId, courseId, text, urgency, teachers, students, courses);
    }
}
