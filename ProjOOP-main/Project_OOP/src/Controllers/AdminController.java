package Controllers;

import Models.Admin;
import Models.User;
import Models.Message;
import Models.Role;
import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    private List<User> users;
    private List<Message> messages;

    public AdminController() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    // Create a new user
    public void createUser(String username, String password, String userId, String nameFirst, String nameLast, String email, Role role) {
        User newUser;
        switch (role.getdisplayRole().toLowerCase()) {
            case "student":
                newUser = new Student(username, password, userId, nameFirst, nameLast, email, 0, 0, 1, null, null, email);
                break;
            case "teacher":
                newUser = new Teacher(username, password, userId, nameFirst, nameLast, email, "teacher");
                break;
            case "admin":
                newUser = new Admin(username, password, userId, nameFirst, nameLast, email, "admin");
                break; 
            case "dean":
                newUser = new Dean(username, password, userId, nameFirst, nameLast, email, "dean");
                break;
            case "rector":
                newUser = new Rector(username, password, userId, nameFirst, nameLast, email, "rector");
                break;
            case "financemanager":
                newUser = new FinanceManager(username, password, userId, nameFirst, nameLast, email, "financemanager");
                break;
            case "manager":
                newUser = new Manager(username, password, userId, nameFirst, nameLast, email, "manager");
                break;
            default:
                throw new IllegalArgumentException("Invalid role type.");
        }
        users.add(newUser);
        System.out.println("User " + username + " created successfully.");
    }

    public static User createUser(String type, String id, String name, String email, String password) {
        return switch (type.toLowerCase()) {
            case "student" -> new Student(id, name, email, password);
            case "teacher" -> new Teacher(id, name, email, password, password, password, null, null, messages);
            case "admin" -> new Admin(id, name, email, password, password, password);
            case "manager" -> new Manager(id, name, email, password);
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        };
    }
}
    // Add a new faculty (placeholder, can be extended based on the use case)
    public void addFaculty(String facultyName) {
        System.out.println("Faculty " + facultyName + " added successfully.");
    }

    // Remove a user by username
    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("User " + username + " removed successfully.");
    }

    // Update user information
    public void updateUser(String username, String password, String type) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(password);
                user.setType(type);
                System.out.println("User " + username + " updated successfully.");
                return;
            }
        }
        System.out.println("User " + username + " not found.");
    }

    // View log files (placeholder for simplicity)
    public void seeLogFiles() {
        System.out.println("Viewing log files...");
        // Logic for viewing log files can be added here.
    }

    // Assign a role to a user by ID
    public void assignRole(String userId, String role) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                user.setRole(role);
                System.out.println("Role " + role + " assigned to user " + userId + " successfully.");
                return;
            }
        }
        System.out.println("User with ID " + userId + " not found.");
    }

    // View all users
    public List<User> viewUsers() {
        return users;
    }

    // View all messages
    public List<Message> viewMessages() {
        return messages;
    }

    // Publish news
    public void publishNews(String title, String content) {
        System.out.println("News published with title: " + title);
        // Logic to store and display news can be added here.
    }

    // Send a message to a user by ID
    public void sentMessage(String text, String recipientId) {
        Message message = new Message("adminId", recipientId, text, System.currentTimeMillis());
        messages.add(message);
        System.out.println("Message sent to user with ID: " + recipientId);
    }
}
