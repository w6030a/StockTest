package biz;

public class User {
	private String name;
	private String password;
	private String email;
	
	public User(String userName, String password, String email) {
		this.name = userName;
		this.password = password;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String userName) {
		this.name = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
