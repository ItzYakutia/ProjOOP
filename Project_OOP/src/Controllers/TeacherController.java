package Controllers;

import Models.*;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherController {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public TeacherController(List<Teacher> teachers, List<Student> students, List<Course> courses) {
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
    }

    // Сортировка преподавателей по фамилии (алфавитно)
    public List<Teacher> sortTeachersByLastName() {
        return teachers.stream()
                .sorted(Comparator.comparing(Teacher::getNameLast))
                .collect(Collectors.toList());
    }
    
    // Просмотр курсов преподавателя
    public List<Course> viewCourses(String teacherId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }
        return teacher.getCourses();
    }

    // Управление курсами (добавление/удаление студентов)
    public void manageCourse(String teacherId, String courseId, String studentId, boolean isAdd) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);
        Student student = findStudentById(studentId);

        if (teacher == null || course == null || student == null) {
            throw new IllegalArgumentException("Teacher, course, or student not found.");
        }

        if (!teacher.getCourses().contains(course)) {
            throw new IllegalArgumentException("This course is not assigned to the teacher.");
        }

        if (isAdd) {
            course.addStudent(student);
            student.addCourse(course);
            System.out.println("Student added to course successfully.");
        } else {
            course.removeStudent(student);
            student.removeCourse(course);
            System.out.println("Student removed from course successfully.");
        }
    }

    // Просмотр студентов и их информации на курсе
    public List<Student> viewStudents(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        return course.getStudents();
    }

    // Выставление оценок
    public void putMarks(String teacherId, String studentId, String courseId, double attestation1, double attestation2, double finalExam) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);
        Student student = findStudentById(studentId);

        if (teacher == null || course == null || student == null) {
            throw new IllegalArgumentException("Teacher, course, or student not found.");
        }

        if (!teacher.getCourses().contains(course)) {
            throw new IllegalArgumentException("Teacher is not assigned to this course.");
        }

        if (attestation1 < 0 || attestation1 > 100 || attestation2 < 0 || attestation2 > 100 || finalExam < 0 || finalExam > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        Mark mark = student.getTranscript().get(course);
        if (mark == null) {
            mark = new Mark(student, course, attestation1, attestation2, finalExam);
            student.getTranscript().put(course, mark);
        } else {
            mark.setAttestation1(attestation1);
            mark.setAttestation2(attestation2);
            mark.setFinalExam(finalExam);
            mark.setTotal(attestation1 + attestation2 + finalExam);
        }

        System.out.println("Marks updated successfully.");
    }

    // Отправка сообщений другим сотрудникам
    public void sendMessage(String teacherId, String recipientId, String messageText) {
        Teacher sender = findTeacherById(teacherId);
        Employee recipient = findEmployeeById(recipientId);

        if (sender == null || recipient == null) {
            throw new IllegalArgumentException("Sender or recipient not found.");
        }

        Message message = new Message(sender, recipient, messageText);
        sender.sendMessage(message);
        System.out.println("Message sent successfully.");
    }

    // Отправка жалоб на студента
    public void sendComplaint(String teacherId, String studentId, String courseId, String text, UrgencyLevel urgency) {
        Teacher teacher = findTeacherById(teacherId);
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (teacher == null || student == null || course == null) {
            throw new IllegalArgumentException("Teacher, student, or course not found.");
        }

        if (!teacher.getCourses().contains(course)) {
            throw new IllegalArgumentException("Teacher is not assigned to this course.");
        }

        String complaint = "Complaint about student: " + student.getNameFirst() + " " + student.getNameLast() +
                ", Course: " + course.getName() +
                ", Urgency: " + urgency +
                ", Text: " + text;

        teacher.addComplaint(complaint);
        System.out.println("Complaint sent successfully.");
    }

    // Вспомогательные методы

    private Teacher findTeacherById(String teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    private Employee findEmployeeById(String employeeId) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }
}
