package com.mybank.model;

public class User {

	private String userId;
	private String firstName;
	private String lastName;
	private String driversLicense;
	private int ssn;
	private String email;
	private String billingAddress;
	private String dob;
	private String gender;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String firstName, String lastName, String driversLicense, int ssn, String email,
			String billingAddress, String dob, String gender, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.driversLicense = driversLicense;
		this.ssn = ssn;
		this.email = email;
		this.billingAddress = billingAddress;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", driversLicense="
				+ driversLicense + ", ssn=" + ssn + ", email=" + email + ", billingAddress=" + billingAddress + ", dob="
				+ dob + ", gender=" + gender + "]";
	}
	
}
