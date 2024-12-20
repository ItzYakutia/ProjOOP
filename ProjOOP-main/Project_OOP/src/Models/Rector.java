package Models;

public class Rector extends Employee {
    public Rector(String id, String name, String email, String password, String department) {
        super(id, name, email, password, department);
    }

    @Override
    public String toString() {
        return "Rector{" + super.toString() + '}';
    }
}
