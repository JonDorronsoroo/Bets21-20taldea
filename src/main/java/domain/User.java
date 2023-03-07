package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String name;
	@Id
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private int age;
	private boolean admin;

	public User(String name, String userName, String email, String password, String confirmPassword, String phoneNumber,
			int age, boolean admin) {
		this.name = name;
		this.userName = userName;
		this.setEmail(email);
		this.setPassword(password);
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.admin = admin;
	}

	public boolean isCorrectPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		} else
			return false;

	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
