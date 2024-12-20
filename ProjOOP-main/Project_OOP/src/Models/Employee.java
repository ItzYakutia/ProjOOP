package Models;

public class Employee extends User {
    private String department;

    public Employee(String id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Employee{" + "department='" + department + '\'' + ", " + super.toString() + '}';
    }
}
