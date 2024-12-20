package Models;

public class Manager extends Employee {
    private String responsibility;

    public Manager(String id, String name, String email, String password, String department, String responsibility) {
        super(id, name, email, password, department);
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return "Manager{" + "responsibility='" + responsibility + '\'' + ", " + super.toString() + '}';
    }
}
