package Controllers;

import Models.*;
import Views.AdminView;
import utils.FileDatabaseHelper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AdminController {
    private Admin admin;
    private AdminView adminView;
    private FileDatabaseHelper databaseHelper;

    public AdminController(Admin admin, AdminView adminView, FileDatabaseHelper databaseHelper) {
        this.admin = admin;
        this.adminView = adminView;
        this.databaseHelper = databaseHelper;
    }

    public void createStudent(String username, String password, String userId, String nameFirst, String nameLast, String email,
                              double gpa, int year, int credits, List<Course> courses, Map<Course, Mark> transcript, Specialty specialty) {
        Student student = new Student(username, password, userId, nameFirst, nameLast, email, gpa, year, credits, courses, transcript, specialty);
        try {
            databaseHelper.saveUserToFile("STUDENT:" + student.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving student to the database: " + e.getMessage());
        }
    }

    public void createTeacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
                              Title title) {
        Teacher teacher = new Teacher(username, password, userId, nameFirst, nameLast, email, title);
        try {
            databaseHelper.saveUserToFile("TEACHER:" + teacher.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving teacher to the database: " + e.getMessage());
        }
    }

    public void createAdmin(String username, String password, String userId, String email, String nameLast, String nameFirst) {
        Admin admin = new Admin(username, password, userId, email, nameLast, nameFirst);
        try {
            databaseHelper.saveUserToFile("ADMIN:" + admin.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving admin to the database: " + e.getMessage());
        }
    }

    public void createManager(String username, String password, String userId, String email, String nameLast,
                              String nameFirst, String department, int teamSize) {
        Manager manager = new Manager(username, password, userId, email, nameLast, nameFirst, department, teamSize);
        try {
            databaseHelper.saveUserToFile("MANAGER:" + manager.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving manager to the database: " + e.getMessage());
        }
    }

    public void createRector(String username, String userId, String firstName, String lastName, String email, double universityBudget, String password) {
        Rector rector = Rector.getInstance(username, userId, firstName, lastName, email, universityBudget, password);
        try {
            databaseHelper.saveUserToFile("RECTOR:" + rector.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving rector to the database: " + e.getMessage());
        }
    }

    public void createDean(String username, String userId, String firstName, String lastName, String email, Faculty faculty, String password) {
        Dean dean = Dean.getInstance(username, userId, firstName, lastName, email, faculty, password);
        try {
            databaseHelper.saveUserToFile("DEAN:" + dean.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving dean to the database: " + e.getMessage());
        }
    }

    public void createResearcher(String username, String userId, String firstName, String lastName, String email, String password) {
        Researcher researcher = new Researcher(username, userId, firstName, lastName, email, password);
        try {
            databaseHelper.saveUserToFile("RESEARCHER:" + researcher.toString());
            adminView.displayAccountCreationConfirmation(true);
        } catch (IOException e) {
            adminView.displayError("Error saving researcher to the database: " + e.getMessage());
        }
    }

    public void displayAllUsers(List<User> users) {
        adminView.displayUserAccounts(users);
    }

    public void displayUserDetails(User user) {
        adminView.displayAccountDetails(user);
    }

    public void updateUser(User user, String newEmail, String newPassword) {
        user.setEmail(newEmail);
        user.setPassword(newPassword);
        adminView.displayAccountUpdateConfirmation(true);
    }

    public void deleteUser(User user) {
        try {
            databaseHelper.deleteUserFromFile(user.getUserId());
            adminView.displayDeleteAccountConfirmation(user, true);
        } catch (IOException e) {
            adminView.displayError("Error deleting user: " + e.getMessage());
        }
    }

    public void viewMessages(List<Message> messages) {
        adminView.displayMessages(messages);
    }

    public void displayAdminProfile() {
        adminView.displayProfile(admin);
    }
}
