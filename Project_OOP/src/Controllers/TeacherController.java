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

    // Добавление нового преподавателя с проверкой уникальности
    public void addTeacher(Teacher newTeacher) {
        if (teachers.stream().anyMatch(teacher -> teacher.equals(newTeacher))) {
            System.out.println("Error: Teacher already exists.");
            return;
        }
        teachers.add(newTeacher);
        System.out.println("Teacher added successfully: " + newTeacher.getNameFirst() + " " + newTeacher.getNameLast());
    }

    // Удаление преподавателя
    public void removeTeacher(Teacher teacherToRemove) {
        if (teachers.remove(teacherToRemove)) { // Используется equals
            System.out.println("Teacher removed successfully: " + teacherToRemove.getNameFirst() + " " + teacherToRemove.getNameLast());
        } else {
            System.out.println("Error: Teacher not found.");
        }
    }

    // Установка оценки для студента по курсу
    public void setMark(String studentId, String courseId, double attestation1, double attestation2, double finalExam) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student == null || course == null) {
            System.out.println("Error: Student or course not found.");
            return;
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

        System.out.println("Mark set successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
    }

    // Отправка жалобы на студента декану
    public void sendComplaint(String studentId, String courseId, String text, UrgencyLevel urgency) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student == null || course == null) {
            System.out.println("Error: Student or course not found.");
            return;
        }

        String complaint = "Complaint about student: " + student.getNameFirst() + " " + student.getNameLast() +
                ", Course: " + course.getName() +
                ", Urgency: " + urgency +
                ", Text: " + text;

        Teacher teacher = findTeacherByCourse(course);
        if (teacher != null) {
            teacher.addComplaint(complaint);
            System.out.println("Complaint sent successfully.");
        } else {
            System.out.println("Error: Teacher not found for the specified course.");
        }
    }

    // Просмотр списка студентов на курсе
    public List<Student> viewStudents(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return null;
        }
        return course.getStudents();
    }

    // Просмотр информации о курсе
    public Course viewCourse(String courseId) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return null;
        }
        return course;
    }

    // Просмотр информации о студенте
    public Student viewStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return null;
        }
        return student;
    }

    // Отправка сообщения другому сотруднику
    public void sendMessage(String text, String employeeId) {
        System.out.println("Message sent to employee ID: " + employeeId + ". Text: " + text);
    }

    // Загрузка силлабуса для курса
    public void loadSyllabus(String courseId, Syllabus syllabus) {
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        course.setSyllabus(syllabus);
        System.out.println("Syllabus loaded successfully for course: " + course.getName());
    }

    // Вспомогательные методы для поиска преподавателей, студентов и курсов
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

    private Teacher findTeacherByCourse(Course course) {
        return teachers.stream()
                .filter(teacher -> teacher.getCourses().contains(course)) // equals используется для сравнения курса
                .findFirst()
                .orElse(null);
    }
}
