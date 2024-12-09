package Models;

public enum Title {
    TUTOR("Tutor"),
    LECTURER("Lecturer"),
    SENIOR_LECTURER("Senior Lecturer"),
    PROFESSOR("Professor");

    private final String displayTitle;

    Title(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String displayTitle() {
        return displayTitle;
    }

    @Override
    public String toString() {
        return displayTitle;
    }
}
