package Controllers;

import Models.*;
import Views.TeacherView;

import java.util.List;

public class TeacherController {

    private final TeacherView teacherView;

    public TeacherController(TeacherView teacherView) {
        this.teacherView = teacherView;
    }

    // Passes Queries to the Model
    public void sortTeachersByLastName(List<Teacher> teachers) {
        teacherView.displaySortedTeachersByLastName(teachers);
    }

    public void viewCourses(Teacher teacher) {
        teacherView.displayTeacherCourses(teacher.getCourses());
    }

    public void manageCourse(Teacher teacher, Course course, boolean isAdd) {
        try {
            if (isAdd) {
                teacher.addCourse(course);
            } else {
                teacher.removeCourse(course);
            }
            teacherView.displaySuccessMessage("Course updated successfully.");
        } catch (IllegalArgumentException e) {
            teacherView.displayErrorMessage(e.getMessage());
        }
    }

    public void assignMarks(Teacher teacher, Student student, Course course, double attestation1, double attestation2, double finalExam) {
        try {
            teacher.assignMark(student, course, attestation1, attestation2, finalExam);
            teacherView.displaySuccessMessage("Marks assigned successfully.");
        } catch (IllegalArgumentException e) {
            teacherView.displayErrorMessage(e.getMessage());
        }
    }

    public void sendComplaint(Teacher teacher, String complaintText) {
        teacher.addComplaint(complaintText);
        teacherView.displaySuccessMessage("Complaint sent successfully.");
    }
}
