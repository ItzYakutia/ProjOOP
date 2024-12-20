package Models;

public class Student extends User {
    private String major;
    private int year;
    private double gpa;
    private Scholarship scholarship;

    public Student(String id, String name, String email, String password, String major, int year, double gpa) {
        super(id, name, email, password);
        this.major = major;
        this.year = year;
        this.gpa = gpa;
    }

    public double getGpa() { return gpa; }
    public Scholarship getScholarship() { return scholarship; }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "Student{" + "major='" + major + '\'' + ", year=" + year + ", gpa=" + gpa +
               ", scholarship=" + scholarship + ", " + super.toString() + '}';
    }
}
