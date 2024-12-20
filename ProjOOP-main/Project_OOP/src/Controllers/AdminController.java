package Controllers;

import Models.User;
import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private List<User> users;

    public AdminController() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void removeUser(String userId) {
        boolean removed = users.removeIf(u -> u.getId().equals(userId));
        if (removed) {
            System.out.println("User removed with ID: " + userId);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    public void listUsers() {
        System.out.println("Listing all users:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
