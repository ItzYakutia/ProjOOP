package Models;

public class Dean extends Employee {
    private String faculty;

    public Dean(String id, String name, String email, String password, String department, String faculty) {
        super(id, name, email, password, department);
        this.faculty = faculty;
    }

    public String getFaculty() { return faculty; }

    @Override
    public String toString() {
        return "Dean{" + "faculty='" + faculty + '\'' + ", " + super.toString() + '}';
    }
}
