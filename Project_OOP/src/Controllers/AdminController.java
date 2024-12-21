package Controllers;

import Models.*;
import Views.AdminView;
import java.util.List;
import java.util.Map;

public class AdminController {
    private Admin admin;
    private AdminView adminView;

    public AdminController(Admin admin, AdminView adminView) {
        this.admin = admin;
        this.adminView = adminView;
    }

    public void createStudent(String username, String password, String userId, String nameFirst, String nameLast, String email,
            double gpa, int year, int credits, List<Course> courses, Map<Course, Mark> transcript, Specialty specialty) {
        Student student = new Student(username, password, userId, nameFirst, nameLast, email, gpa, year, credits, courses, transcript, specialty);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createTeacher(String username, String password, String userId, String nameFirst, String nameLast, String email,
            Title title) {
        Teacher teacher = new Teacher(username, password, userId, nameFirst, nameLast, email, title);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createAdmin(String username, String password, String userId, String email, String nameLast, String nameFirst) {
    	Admin admin = new Admin(username, password, userId, email, nameLast, nameFirst);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createManager(String username, String password, String userId, String email, String nameLast, 
    		String nameFirst, String department, int teamSize) {
        Manager manager = new Manager(username, password, userId, email, nameLast, nameFirst, department, teamSize);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createRector(String username, String userId, String firstName, String lastName, String email, double universityBudget, String password) {
        Rector rector = Rector.getInstance(username, userId, firstName, lastName, email, universityBudget, password);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createDean(String username, String userId, String firstName, String lastName, String email, Faculty faculty, String password) {
        Dean dean = new Dean(username, userId, firstName, lastName, email, faculty, password);
        adminView.displayAccountCreationConfirmation(true);
    }

    public void createResearcher(String username, String userId, String firstName, String lastName, String email, String password) {
        Researcher researcher = new Researcher(username, userId, firstName, lastName, email, password);
        adminView.displayAccountCreationConfirmation(true);
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
        if (userList.contains(user)) {
            userList.remove(user); // Remove the user from the list
            user.receiveNotification("Your account has been deleted by an administrator."); // Notify the user
            adminView.displayDeleteAccountConfirmation(user, true);
        } else {
            adminView.displayDeleteAccountConfirmation(user, false);
        }
    }

    public void viewMessages(List<Message> messages) {
        adminView.displayMessages(messages);
    }

    public void displayAdminProfile() {
        adminView.displayProfile(admin);
    }
}
