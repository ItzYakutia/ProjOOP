package Controllers;

import Models.*;
import java.util.List;
import java.util.Map;

public class AdminController {
    private Admin admin;

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    public void createStudent(String username, String password, String userId, String nameFirst, String nameLast, String email,
                              double gpa, int year, int credits, List<Course> courses, Map <Course, Mark> transcript, Specialty specialty) {
        Student student = new Student(username, password, userId, nameFirst, nameLast, email, gpa, year, credits, courses, transcript, specialty);
        boolean success = admin.saveStudent(student);
        if (success) {
            System.out.println("Student account created successfully.");
        } else {
            System.out.println("Failed to create student account.");
        }
    }

    public void createTeacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                              Title title) {
        Teacher teacher = new Teacher(username, password, userId, nameFirst, nameLast, email, title);
        boolean success = admin.saveTeacher(teacher);
        if (success) {
            System.out.println("Teacher account created successfully.");
        } else {
            System.out.println("Failed to create teacher account.");
        }
    }

    public void createAdmin(String username, String password, String userId, String email, String nameLast, String nameFirst) {
        Admin admin = new Admin(username, password, userId, email, nameLast, nameFirst);
        boolean success = admin.saveAdmin(admin);
        if (success) {
            System.out.println("Admin account created successfully.");
        } else {
            System.out.println("Failed to create admin account.");
        }
    }

    public void createManager(String username, String password, String userId, String email, String nameLast,
                              String nameFirst, String department, int teamSize) {
        Manager manager = new Manager(username, password, userId, email, nameLast, nameFirst, department, teamSize);
        boolean success = admin.saveManager(manager);
        if (success) {
            System.out.println("Manager account created successfully.");
        } else {
            System.out.println("Failed to create manager account.");
        }
    }

    public void createRector(String username, String userId, String firstName, String lastName, String email, double universityBudget, String password) {
        Rector rector = Rector.getInstance(username, userId, firstName, lastName, email, universityBudget, password);
        boolean success = admin.saveRector(rector);
        if (success) {
            System.out.println("Rector account created successfully.");
        } else {
            System.out.println("Failed to create rector account.");
        }
    }

    public void createDean(String username, String userId, String firstName, String lastName, String email, Faculty faculty, String password) {
        Dean dean = Dean.getInstance(username, userId, firstName, lastName, email, faculty, password);
        boolean success = admin.saveDean(dean);
        if (success) {
            System.out.println("Dean account created successfully.");
        } else {
            System.out.println("Failed to create dean account.");
        }
    }

    public void createResearcher(String username, String userId, String firstName, String lastName, String email, String password) {
        Researcher researcher = new Researcher(username, userId, firstName, lastName, email, password);
        boolean success = admin.saveResearcher(researcher);
        if (success) {
            System.out.println("Researcher account created successfully.");
        } else {
            System.out.println("Failed to create researcher account.");
        }
    }

    public void updateUser(User user, String newEmail, String newPassword) {
        boolean success = admin.updateUser(user, newEmail, newPassword);
        if (success) {
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("Failed to update account.");
        }
    }

    public void deleteUser(User user) {
        boolean success = admin.deleteUser(user.getUserId());
        if (success) {
            System.out.println("Account for user " + user.getUsername() + " successfully deleted.");
        } else {
            System.out.println("Failed to delete account for user " + user.getUsername() + ".");
        }
    }

    public void displayAllUsers() {
        List<User> users = admin.getAllUsers();
        users.forEach(user -> System.out.println(user));
    }

    public void displayUserDetails(User user) {
        User userDetails = admin.getUserDetails(user.getUserId());
        if (userDetails != null) {
            System.out.println(userDetails);
        } else {
            System.out.println("User not found.");
        }
    }
}
