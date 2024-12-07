package Models;

public abstract class User {
	private String username;
	private String password;
	private String userId;
	private String nameFirst;
	private String nameLast;
	private String email; // ...@kbtu.kz (example: e_keskil@kbtu.kz email will be: "e_keskil")
	
	public User(String username, String password) {
		this.username = username;
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
