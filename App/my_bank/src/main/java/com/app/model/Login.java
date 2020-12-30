package com.app.model;

public class Login {

	private String username;
	private String password;
	private int customerId;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String username, String password, int customerId) {
		super();
		this.username = username;
		this.password = password;
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", customerId=" + customerId + "]";
	}
	
	
}
