package Views;

import Models.*;

import java.util.List;

public class CourseView {

    // Отображение сообщения об успешной операции
    public void displaySuccessMessage(String message) {
        System.out.println("SUCCESS: " + message);
    }

    // Отображение сообщения об ошибке
    public void displayErrorMessage(String message) {
        System.out.println("ERROR: " + message);
    }

    // Отображение информации о курсе
    public void displayCourseInfo(Course course) {
        System.out.println("Course Information:");
        System.out.println("- ID: " + course.getCourseId());
        System.out.println("- Name: " + course.getName());
        System.out.println("- Description: " + course.getDescription());
        System.out.println("- Credits: " + course.getCredits());
        System.out.println("- Course Type: " + course.getCourseType());
        System.out.println("- School: " + course.getSchool().getFullName());
        System.out.println("- Enrolled Students: " + course.getEnrolledStudents().size());
        System.out.println("- Assigned Teachers: " + course.getAssignedTeachers().size());
    }

    // Отображение студентов, зарегистрированных на курс
    public void displayEnrolledStudents(Course course) {
        System.out.println("Enrolled Students for Course: " + course.getName());
        List<Student> students = course.getEnrolledStudents();
        if (students.isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            students.forEach(student -> System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() + 
                " (GPA: " + student.getGpa() + ")"));
        }
    }

    // Отображение преподавателей, назначенных на курс
    public void displayAssignedTeachers(Course course) {
        System.out.println("Assigned Teachers for Course: " + course.getName());
        List<Teacher> teachers = course.getAssignedTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No teachers are assigned to this course.");
        } else {
            teachers.forEach(teacher -> System.out.println("- " + teacher.getNameFirst() + " " + teacher.getNameLast()));
        }
    }

    // Отображение успешного добавления студента на курс
    public void displayStudentEnrolledSuccess(Course course, Student student) {
        System.out.println("SUCCESS: Student " + student.getNameFirst() + " " + student.getNameLast() +
                " successfully enrolled in course: " + course.getName());
    }

    // Отображение успешного удаления студента с курса
    public void displayStudentUnenrolledSuccess(Course course, Student student) {
        System.out.println("SUCCESS: Student " + student.getNameFirst() + " " + student.getNameLast() +
                " successfully removed from course: " + course.getName());
    }

    // Отображение успешного назначения преподавателя на курс
    public void displayTeacherAssignedSuccess(Course course, Teacher teacher) {
        System.out.println("SUCCESS: Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " successfully assigned to course: " + course.getName());
    }

    // Отображение успешного удаления преподавателя с курса
    public void displayTeacherRemovedSuccess(Course course, Teacher teacher) {
        System.out.println("SUCCESS: Teacher " + teacher.getNameFirst() + " " + teacher.getNameLast() +
                " successfully removed from course: " + course.getName());
    }

    // Отображение отсортированных студентов
    public void displaySortedStudents(List<Student> students, String criterion) {
        System.out.println("Sorted Students by " + criterion + ":");
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            students.forEach(student -> System.out.println("- " + student.getNameFirst() + " " + student.getNameLast() +
                    " (GPA: " + student.getGpa() + ")"));
        }
    }

    // Отображение отсортированных курсов
    public void displaySortedCourses(List<Course> courses, String criterion) {
        System.out.println("Sorted Courses by " + criterion + ":");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            courses.forEach(course -> System.out.println("- " + course.getName() +
                    " (Students: " + course.getEnrolledStudents().size() + ", Credits: " + course.getCredits() + ")"));
        }
    }
}
