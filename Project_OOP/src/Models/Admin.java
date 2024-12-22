package Models;

import java.util.Objects;

public class Admin extends User {
    public Admin(String username, String password, String userId, String email, String nameLast, String nameFirst) {
        super(username, password, userId, email, nameLast, nameFirst);
    }

    @Override
    public void receiveNotification(String message) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getUsername(), admin.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUsername());
    }

    @Override
    public void sendMessage(String recipientUserId, String message) {
        System.out.println("Message from " + getUserId() + " to " + recipientUserId + ": " + message);
    }
}
