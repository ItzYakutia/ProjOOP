package Models;

public enum Specialty {
    SOFTWARE_ENGINEERING("Software Engineering", School.SITE),
    COMPUTER_SCIENCE("Computer Science", School.SITE),
    INFORMATION_SECURITY("Information Security", School.SITE),
    FINANCE("Finance", School.BS),
    MANAGEMENT("Management", School.BS),
    MARKETING("Marketing", School.BS);

    private final String displayName;
    private final School school;

    Specialty(String displayName, School school) {
        this.displayName = displayName;
        this.school = school;
    }

    public String getDisplayName() {
        return displayName;
    }

    public School getSchool() {
        return school;
    }
}
