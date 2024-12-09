package Models;

public enum LessonType {
    LECTURE("Lecture"),
    PRACTICE("Practice"),
    FINAL("Final");

    private final String displayType;

    LessonType(String displayType) {
        this.displayType = displayType;
    }

    public String displayType() {
        return displayType;
    }

    @Override
    public String toString() {
        return displayType;
    }
}
