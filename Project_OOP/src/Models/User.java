package Models;

public abstract class User {
    private String username;
    protected String password;
    private String userId;
    private String nameFirst;
    private String nameLast;
    private String email; // ...@kbtu.kz (example: e_keskil@kbtu.kz email will be: "e_keskil")

    public User(String username, String password, String userId, String email, String nameLast, String nameFirst) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.nameLast = nameLast;
        this.nameFirst = nameFirst;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String currentPassword, String newPassword) {
        if (currentPassword != null && currentPassword.equals(this.password)) {
            if (newPassword != null && !newPassword.isEmpty()) {
                this.password = newPassword;
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("New password cannot be empty.");
            }
        } else {
            System.out.println("Current password is incorrect.");
        }
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", userId='" + userId + '\'' +
               ", nameFirst='" + nameFirst + '\'' +
               ", nameLast='" + nameLast + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
    
    public abstract void receiveNotification(String message);
}
