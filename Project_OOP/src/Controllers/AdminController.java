package Controllers;

import Models.*;
import Views.AdminView;
import java.util.List;

public class AdminController {
    private Admin admin;
    private AdminView adminView;

    public AdminController(Admin admin, AdminView adminView) {
        this.admin = admin;
        this.adminView = adminView;
    }

    public void createUser(String type, String id, String name, String email, String password) {
        User user = switch (type.toLowerCase()) {
            case "student" -> new Student(id, name, email, password, password, password, 0, 0, 0, null, null, password);
            case "teacher" -> new Teacher(id, name, email, password, password, password, null, null, null);
            case "admin" -> new Admin(id, name, email, password, password, password);
            case "manager" -> new Manager(id, name, email, password, password, password, password, 0);
            default -> null;
        };

        if (user != null) {
            // Simulate saving user (e.g., adding to database or list)
            adminView.displayAccountCreationConfirmation(true);
        } else {
            adminView.displayAccountCreationConfirmation(false);
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
        // Simulate user deletion
        adminView.displayDeleteAccountConfirmation(user, true);
    }

    public void viewMessages(List<Message> messages) {
        adminView.displayMessages(messages);
    }

    public void displayAdminProfile() {
        adminView.displayProfile(admin);
    }
}
