package Models;

public enum NewsType {
    ACADEMIC("Academic"),
    RESEARCH("Research"),
    EVENTS("Events"),
    CAMPUS_LIFE("Campus Life"),
    ADMISSIONS("Admissions"),
    ALUMNI("Alumni"),
    FACILITIES("Facilities"),
    POLICY("Policy"),
    STUDENT_ACHIEVEMENTS("Student Achievements");
    
    private final String displayName;
    
    NewsType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
