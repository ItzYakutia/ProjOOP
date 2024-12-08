package Models;

public class Manager extends User {
    private String department;
    private int teamSize;

    public Manager(String username, String password, String userId, String email, 
                   String nameLast, String nameFirst, String department, int teamSize) {
        super(username, password, userId, email, nameLast, nameFirst);
        this.department = department;
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nDepartment: " + department +
               "\nTeam Size: " + teamSize;
    }
}
