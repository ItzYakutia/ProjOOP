package Controllers;

import Models.Student;
import java.util.List;

public class DeanController {
    public void viewStudentPerformance(List<Student> students) {
        System.out.println("Viewing student performance:");
        for (Student student : students) {
            System.out.println(student.getName() + " - GPA: " + student.getGpa());
        }
    }
}
