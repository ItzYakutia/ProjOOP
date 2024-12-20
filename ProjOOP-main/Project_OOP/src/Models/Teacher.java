package Models;

public class Teacher extends Employee {
    private TeacherTitle title;

    public Teacher(String id, String name, String email, String password, String department, TeacherTitle title) {
        super(id, name, email, password, department);
        this.title = title;
    }

    public TeacherTitle getTitle() { return title; }

    @Override
    public String toString() {
        return "Teacher{" + "title=" + title + ", " + super.toString() + '}';
    }
}
