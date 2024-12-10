package Models;

public abstract class Employee extends User{

	public Employee(String username, String password, String userId, String email, String nameLast, String nameFirst) {
		super(username, password, userId, email, nameLast, nameFirst);
	}

}
