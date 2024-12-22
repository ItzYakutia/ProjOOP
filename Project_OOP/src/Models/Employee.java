package Models;

public abstract class Employee extends User{
	private Researcher researcherProfile;
	public Employee(String username, String password, String userId, String email, String nameLast, String nameFirst) {
		super(username, password, userId, email, nameLast, nameFirst);
	}
	public void becomeResearcher() {
        if (researcherProfile == null) {
            this.researcherProfile = new Researcher(getUsername(), getUserId(), getNameFirst(), getNameLast(), getEmail(), getPassword());
            System.out.println("Employee " + getNameFirst() + " " + getNameLast() + " became a Researcher.");
        } else {
            System.out.println("Employee " + getNameFirst() + " " + getNameLast() + " is already a Researcher.");
        }
    }

    	public Researcher getResearcherProfile() {
        	return researcherProfile;
    }
}
