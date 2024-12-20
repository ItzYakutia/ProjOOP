package Controllers;

import Models.Course;
import java.util.List;

public class RectorController {
    public void approveCourse(List<Course> courses, Course courseToApprove) {
        if (courses.contains(courseToApprove)) {
            System.out.println("Course approved: " + courseToApprove.getCourseName());
        } else {
            System.out.println("Course not found in list.");
        }
    }
}
