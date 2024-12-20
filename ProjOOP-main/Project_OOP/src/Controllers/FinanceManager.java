package Controllers;

import Models.FinanceManager;
import Models.Scholarship;
import Models.Student;
import java.util.List;

public class FinanceManagerController {
    private FinanceManager financeManager;

    public FinanceManagerController(FinanceManager financeManager) {
        this.financeManager = financeManager;
    }

    public void allocateScholarships(List<Student> students) {
        System.out.println("Allocating scholarships...");
        for (Student student : students) {
            if (student.getGpa() >= 3.5) {
                student.setScholarship(new Scholarship(1000, "Merit-based"));
                System.out.println("Scholarship allocated to: " + student.getName());
            }
        }
    }

    public void printBudget() {
        System.out.println("Remaining Budget: $" + financeManager.getBudget());
    }
}
