package Controllers;

import Models.Mark;
import java.util.HashMap;
import java.util.Map;

public class TeacherController {
    private Map<String, Mark> studentMarks;

    public TeacherController() {
        this.studentMarks = new HashMap<>();
    }

    public void assignMark(String studentId, Mark mark) {
        studentMarks.put(studentId, mark);
        System.out.println("Mark assigned for student: " + studentId + " -> " + mark);
    }

    public void viewMarks() {
        System.out.println("All marks:");
        for (Map.Entry<String, Mark> entry : studentMarks.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Mark: " + entry.getValue());
        }
    }
}
