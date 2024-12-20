package Main;

import Controllers.*;
import Models.*;
import Views.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация контроллеров
        AdminController adminController = new AdminController();
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        RectorController rectorController = new RectorController();
        DeanController deanController = new DeanController();
        ManagerController managerController = new ManagerController();
        FinanceManagerController financeManagerController = new FinanceManagerController(new FinanceManager("FM1", "Finance Manager", "finance@example.com", "password", 10000.0));
        ResearcherController researcherController = new ResearcherController(new ArrayList<>());
        EmployeeController employeeController = new EmployeeController();
        NewsController newsController = new NewsController();
        MessageController messageController = new MessageController();
        LessonController lessonController = new LessonController();
        FinanceOfficeController financeOfficeController = new FinanceOfficeController(new FinanceOffice("Main Finance Office"));

        // Инициализация представлений
        AdminView adminView = new AdminView(adminController);
        StudentView studentView = new StudentView(studentController);
        TeacherView teacherView = new TeacherView(teacherController);
        RectorView rectorView = new RectorView(rectorController);
        DeanView deanView = new DeanView(deanController);
        ManagerView managerView = new ManagerView(managerController);
        FinanceManagerView financeManagerView = new FinanceManagerView(financeManagerController);
        ResearcherView researcherView = new ResearcherView(researcherController);
        EmployeeView employeeView = new EmployeeView(employeeController);
        NewsView newsView = new NewsView(newsController);
        MessageView messageView = new MessageView(messageController);
        LessonView lessonView = new LessonView(lessonController);
        FinanceOfficeView financeOfficeView = new FinanceOfficeView(financeOfficeController);

        // Главное меню
        int choice;
        do {
            System.out.println("=== University Management System ===");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Teacher");
            System.out.println("4. Rector");
            System.out.println("5. Dean");
            System.out.println("6. Manager");
            System.out.println("7. Finance Manager");
            System.out.println("8. Researcher");
            System.out.println("9. Employee");
            System.out.println("10. News");
            System.out.println("11. Messages");
            System.out.println("12. Lessons");
            System.out.println("13. Finance Office");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> adminView.displayMenu();
                case 2 -> studentView.displayMenu();
                case 3 -> teacherView.displayMenu();
                case 4 -> rectorView.displayMenu(new ArrayList<>()); // Передать список курсов
                case 5 -> deanView.displayStudentPerformance(new ArrayList<>()); // Передать список студентов
                case 6 -> managerView.displayMenu();
                case 7 -> financeManagerView.displayMenu(new ArrayList<>()); // Передать список студентов
                case 8 -> researcherView.displayMenu();
                case 9 -> employeeView.displayMenu();
                case 10 -> newsView.displayMenu();
                case 11 -> messageView.displayMenu();
                case 12 -> lessonView.displayMenu();
                case 13 -> financeOfficeView.displayMenu();
                case 0 -> System.out.println("Exiting System...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}
