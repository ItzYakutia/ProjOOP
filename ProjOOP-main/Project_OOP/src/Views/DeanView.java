package Views;

import Controllers.DeanController;
import Models.Student;
import java.util.List;

public class DeanView {
    private DeanController controller;

    public DeanView(DeanController controller) {
        this.controller = controller;
    }

    public void displayStudentPerformance(List<Student> students) {
        System.out.println("=== Dean Menu ===");
        controller.viewStudentPerformance(students);
    }
}
