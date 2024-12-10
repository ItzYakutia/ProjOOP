package Controllers;

import Models.*;
import java.util.List;

public class AdminController {

    private Admin admin;

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    //
    public User createUser(String type, String id, String name, String email, String password) {
        return switch (type.toLowerCase()) {
            case "student" -> new Student(id, name, email, password, password, password, 0, 0, 0, null, null, password);
            case "teacher" -> new Teacher(id, name, email, password, password, password, null, null, null);
            case "admin" -> new Admin(id, name, email, password, password, password);
            case "manager" -> new Manager(id, name, email, password, password, password, password, 0);
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        };
    }


    public void addFaculty(String facultyName) {
        System.out.println("Adding faculty: " + facultyName);
        //
    }

    public void removeUser(String username) {
        System.out.println("Removing user: " + username);
        // 
    }

    public void updateUser(String username, String password, String type) {
        System.out.println("Updating user: " + username + ", Type: " + type);
        // 
    }

    public void seeLogFiles() {
        System.out.println("Viewing log files:");
        // 
    }

    public void assignRole(String userId, String role) {
        System.out.println("Assigning role: " + role + " to user ID: " + userId);
        // 
    }

    public List<User> viewUsers() {
        System.out.println("Viewing all users:");
        return null; 
    }

    public List<Message> viewMessages() {
        System.out.println("Viewing all messages:");
        return null; 
    }

    public void publishNews(String title, String content) {
        System.out.println("Publishing news: " + title);
        System.out.println("Content: " + content);
    }
}
