package Views;

import Models.*;
import java.util.List;

public class AdminView {

    public void displayUserAccounts(List<User> users) {
        System.out.println("User Accounts:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void displayAccountDetails(User user) {
        System.out.println("Account Details:");
        System.out.println(user);
    }

    public void displayCreateAccountForm() {
        System.out.println("Create New Account:");
        System.out.println("Please fill in the required details.");
    }

    public void displayAccountCreationConfirmation(boolean success) {
        if (success) {
            System.out.println("Account creation successful.");
        } else {
            System.out.println("Account creation failed.");
        }
    }

    public void displayUpdateAccountForm(User user) {
        System.out.println("Update Account Details for:");
        System.out.println(user);
        System.out.println("Please enter new details.");
    }

    public void displayAccountUpdateConfirmation(boolean success) {
        if (success) {
            System.out.println("Account update successful.");
        } else {
            System.out.println("Account update failed.");
        }
    }

    public void displayDeleteAccountConfirmation(User user, boolean success) {
        if (success) {
            System.out.println("Account for user " + user.getUsername() + " successfully deleted.");
        } else {
            System.out.println("Failed to delete account for user " + user.getUsername() + ".");
        }
    }

    public void displaySettingsUpdateConfirmation(boolean success) {
        if (success) {
            System.out.println("System settings updated successfully.");
        } else {
            System.out.println("Failed to update system settings.");
        }
    }

    public void displayMessages(List<Message> messages) {
        System.out.println("Messages:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    public void displayProfile(Admin admin) {
        System.out.println("Admin Profile:");
        System.out.println(admin);
    }
}
