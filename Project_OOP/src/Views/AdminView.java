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

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
    
    public void displayNews(List<News> newsList) {
        if (newsList != null && !newsList.isEmpty()) {
            System.out.println("News Articles:");
            for (News news : newsList) {
                System.out.println(news);
            }
        } else {
            System.out.println("No news articles found.");
        }
    }

    public void displayNewsDetails(News news) {
        if (news != null) {
            System.out.println("News Details:");
            System.out.println(news);
        } else {
            System.out.println("News not found.");
        }
    }

    public void displayNewsCreationForm() {
        System.out.println("Create New News:");
        System.out.println("Please fill in the required details.");
    }

    public void displayNewsCreationConfirmation(boolean success) {
        if (success) {
            System.out.println("News creation successful.");
        } else {
            System.out.println("News creation failed.");
        }
    }

    public void displayNewsUpdateForm(String title, String currentContent) {
        System.out.println("Update News Details for Title: " + title);
        System.out.println("Current Content: " + currentContent);
        System.out.println("Please enter the new content.");
    }

    public void displayNewsUpdateConfirmation(boolean success) {
        if (success) {
            System.out.println("News updated successfully.");
        } else {
            System.out.println("News update failed.");
        }
    }

    public void displayNewsDeletionConfirmation(boolean success) {
        if (success) {
            System.out.println("News deleted successfully.");
        } else {
            System.out.println("News deletion failed.");
        }
    }
}
