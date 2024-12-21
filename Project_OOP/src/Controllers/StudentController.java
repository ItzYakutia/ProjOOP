package Controllers;

import Models.*;
import Views.StudentView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentController {

    private final StudentView studentView;

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
    }

    // Показ всех факультетов
    public void viewFaculties() {
        studentView.displayFaculties();
    }

    // Показ специальностей для выбранного факультета
    public void viewSpecialties(Faculty faculty) {
        studentView.displaySpecialties(faculty);
    }

    // Выбор факультета и специальности для студента
    public void chooseFacultyAndSpecialty(Student student, Faculty faculty, String specialty) {
        boolean isValid = validateSpecialty(faculty, specialty);

        if (!isValid) {
            studentView.displaySpecialtyError("Invalid specialty for the chosen faculty.");
            return;
        }

        student.setFaculty(faculty);
        student.setSpecialty(specialty);

        studentView.displayFacultyAndSpecialtyChosen(faculty, specialty);
    }

    // Проверка, соответствует ли специальность выбранному факультету
    private boolean validateSpecialty(Faculty faculty, String specialty) {
        switch (faculty) {
            case SITE:
                for (SiteSpecialty siteSpecialty : SiteSpecialty.values()) {
                    if (siteSpecialty.getFullName().equalsIgnoreCase(specialty)) {
                        return true;
                    }
                }
                break;
            case BS:
                for (BsSpecialty bsSpecialty : BsSpecialty.values()) {
                    if (bsSpecialty.getFullName().equalsIgnoreCase(specialty)) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    // Показ всех доступных курсов
    public void viewCourses(List<Course> courses) {
        studentView.displayCourses(courses);
    }

    // Регистрация студента на курс
    public void registerForCourse(Student student, Course course) {
        if (student.getCredits() + course.getCredits() > 21) {
            studentView.displayRegistrationError("Student cannot register for more than 21 credits.");
            return;
        }

        student.addCourse(course);
        course.addStudent(student);

        studentView.displayRegistrationSuccess(course, student);
    }

    // Просмотр транскрипта студента
    public void viewTranscript(Student student) {
        studentView.displayTranscript(student);
    }

    // Оценка преподавателя
    public void rateTeacher(Teacher teacher, int rating, String feedback) {
        if (rating < 1 || rating > 5) {
            studentView.displayCourseRatingError("Rating must be between 1 and 5.");
            return;
        }

        teacher.addRating(rating);
        studentView.displayCourseRatingSuccess(teacher.getNameFirst() + " " + teacher.getNameLast(), rating, feedback);
    }

    // Показ новостей
    public void viewNews(List<News> news) {
        studentView.displayNews(news);
    }

    // Пример сортировки студентов по имени
    public void sortStudentsByName(List<Student> students) {
        List<Student> sortedStudents = students.stream()
                .sorted((s1, s2) -> {
                    int firstNameComparison = s1.getNameFirst().compareToIgnoreCase(s2.getNameFirst());
                    return firstNameComparison != 0 ? firstNameComparison :
                            s1.getNameLast().compareToIgnoreCase(s2.getNameLast());
                })
                .collect(Collectors.toList());

        studentView.displaySortedStudents(sortedStudents);
    }

    // Пример сортировки студентов по GPA
    public void sortStudentsByGPA(List<Student> students) {
        List<Student> sortedStudents = students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())) // По убыванию
                .collect(Collectors.toList());

        studentView.displaySortedStudents(sortedStudents);
    }

    // Проверка количества проваленных курсов
    public void checkFailedCourses(Student student) {
        long failedCourses = student.getTranscript().values().stream()
                .filter(mark -> mark.getTotal() < 50) // Менее 50 - провал
                .count();

        if (failedCourses > 3) {
            studentView.displayFailedCoursesWarning(student);
        } else {
            studentView.displayFailedCoursesResult(student, failedCourses);
        }
    }

    // Вспомогательные методы для поиска
    public Student findStudentById(List<Student> students, String studentId) {
        return students.stream()
                .filter(student -> student.getUserId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    public Course findCourseById(List<Course> courses, String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    public Teacher findTeacherById(List<Teacher> teachers, String teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getUserId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }
}

