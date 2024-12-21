package Models;

public enum CourseType {
    MAJOR("Major"),
    MINOR("Minor"),
    FREE_ELECTIVE("Free elective");

    private final String displayType;

    CourseType(String displayType) {
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
