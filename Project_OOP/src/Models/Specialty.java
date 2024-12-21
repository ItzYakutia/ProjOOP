package Models;

public enum Specialty {
    COMPUTER_SCIENCE("Computer Science"),
    INFORMATION_TECHNOLOGY("Information Technology"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    DATA_SCIENCE("Data Science"),
    CYBER_SECURITY("Cyber Security"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence");

    private final String displayName;

    Specialty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
