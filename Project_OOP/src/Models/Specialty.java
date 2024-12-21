package Models;

public enum Specialty {

    SOFTWARE_ENGINEERING("Software Engineering", "SITE"),
    COMPUTER_SCIENCE("Computer Science", "SITE"),
    PETROLEUM_ENGINEERING("Petroleum Engineering", "Oil and Gas"),
    MECHANICAL_ENGINEERING("Mechanical Engineering", "Engineering"),
    ELECTRICAL_ENGINEERING("Electrical Engineering", "Engineering");

    private final String displayName;
    private final String school; // Школа, к которой относится специальность

    Specialty(String displayName, String school) {
        this.displayName = displayName;
        this.school = school;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSchool() {
        return school;
    }
}
