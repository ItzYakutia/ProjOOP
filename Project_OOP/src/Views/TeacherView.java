package Views;

import Models.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherView {

    // Сортировка преподавателей по фамилии
    public void displaySortedTeachersByLastName(List<Teacher> teachers) {
        List<Teacher> sortedTeachers = teachers.stream()
                .sorted(Comparator.comparing(Teacher::getNameLast))
                .collect(Collectors.toList());

        System.out.println("Sorted Teachers by Last Name:");
        for (Teacher teacher : sortedTeachers) {
            System.out.println("- " + teacher.getNameLast() + ", " + teacher.getNameFirst());
        }
    }

    // Просмотр курсов преподавателя
    public void displayTeacherCourses(String teacherId, List<Teacher> teachers) {
        Teacher teacher = findTeacherById(teacherId, teachers);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.println("Courses for teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() + ":");
        for (Course course : teacher.getCourses()) {
            System.out.println("- " + course.getName());
        }
    }

    // Управление курсами (добавление/удаление студентов)
    public void manageCourse(String teacherId, String courseId, String studentId, boolean isAdd, 
                             List<Teacher> teachers, List<Course> courses, List<Student> students) {
        Teacher teacher = findTeacherById(teacherId, teachers);
        Course course = findCourseById(courseId, courses);
        Student student = findStudentById(studentId, students);

        if (teacher == null || course == null || student == null) {
            System.out.println("Teacher, course, or student not found.");
            return;
        }

        if (!teacher.getCourses().contains(course)) {
            System.out.println("This course is not assigned to the teacher.");
            return;
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

    // Просмотр студентов на курсе
    public void displayStudentsInCourse(String courseId, List<Course> courses) {
        Course course = findCourseById(courseId, courses);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Students in course " + course.getName() + ":");
        for (Student student : course.getStudents()) {
            System.out.println("- " + student.getNameFirst() + " " + student.getNameLast());
        }
    }

    // Выставление оценок
    public void putMarks(String teacherId, String studentId, String courseId, double attestation1, 
                         double attestation2, double finalExam, List<Teacher> teachers, 
                         List<Course> courses, List<Student> students) {
        Teacher teacher = findTeacherById(teacherId, teachers);
        Course course = findCourseById(courseId, courses);
        Student student = findStudentById(studentId, students);

        if (teacher == null || course == null || student == null) {
            System.out.println("Teacher, course, or student not found.");
            return;
        }

        if (!teacher.getCourses().contains(course)) {
            System.out.println("Teacher is not assigned to this course.");
            return;
        }

        if (attestation1 < 0 || attestation1 > 100 || attestation2 < 0 || attestation2 > 100 || finalExam < 0 || finalExam > 100) {
            System.out.println("Marks must be between 0 and 100.");
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

        System.out.println("Marks updated successfully for student: " + student.getNameFirst() + " " + student.getNameLast());
    }

    // Отправка сообщений другим сотрудникам
    public void sendMessage(String teacherId, String recipientId, String messageText, List<Teacher> teachers, List<Employee> employees) {
        Teacher sender = findTeacherById(teacherId, teachers);
        Employee recipient = findEmployeeById(recipientId, employees);

        if (sender == null || recipient == null) {
            System.out.println("Sender or recipient not found.");
            return;
        }

        Message message = new Message(sender, recipient, messageText);
        sender.sendMessage(message);
        System.out.println("Message sent successfully.");
    }

    // Отправка жалоб на студента
    public void sendComplaint(String teacherId, String studentId, String courseId, String text, UrgencyLevel urgency, 
                              List<Teacher> teachers, List<Student> students, List<Course> courses) {
        Teacher teacher = findTeacherById(teacherId, teachers);
        Student student = findStudentById(studentId, students);
        Course course = findCourseById(courseId, courses);

        if (teacher == null || student == null || course == null) {
            System.out.println("Teacher, student, or course not found.");
            return;
        }

        if (!teacher.getCourses().contains(course)) {
            System.out.println("Teacher is not assigned to this course.");
            return;
        }

        String complaint = "Complaint about student: " + student.getNameFirst() + " " + student.getNameLast() +
                ", Course: " + course.getName() +
                ", Urgency: " + urgency +
                ", Text: " + text;

        teacher.addComplaint(complaint);
        System.out.println("Complaint sent successfully.");
    }

    // Вспомогательные методы
    private Teacher findTeacherById(String teacherId, List<Teacher> teachers) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String courseId, List<Course> courses) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentById(String studentId, List<Student> students) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    private Employee findEmployeeById(String employeeId, List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getUserId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }
}
