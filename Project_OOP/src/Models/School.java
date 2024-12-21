package Models;

public enum School {
    SITE("School of Information Technology and Engineering"),
    BS("Business School");

    private final String fullName;

    School(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
