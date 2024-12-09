package Models;

public enum UrgencyLevel {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String displayLevel;

    UrgencyLevel(String displayLevel) {
        this.displayLevel = displayLevel;
    }

    public String displayLevel() {
        return displayLevel;
    }

    @Override
    public String toString() {
        return displayLevel;
    }
}
