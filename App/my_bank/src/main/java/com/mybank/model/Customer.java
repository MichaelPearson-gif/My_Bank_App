package com.mybank.model;

import java.util.Date;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String driversLicense;
	private String ssn;
	private String email;
	private String physicalAddress;
	private String mailAddress;
	private Date dob;
	private String gender;
	private int creditScore;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String firstName, String lastName, String driversLicense, String ssn, String email,
			String physicalAddress, String mailAddress, Date dob, String gender, int creditScore) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.driversLicense = driversLicense;
		this.ssn = ssn;
		this.email = email;
		this.physicalAddress = physicalAddress;
		this.mailAddress = mailAddress;
		this.dob = dob;
		this.gender = gender;
		this.creditScore = creditScore;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", driversLicense=" + driversLicense + ", ssn=" + ssn + ", email=" + email + ", physicalAddress="
				+ physicalAddress + ", mailAddress=" + mailAddress + ", dob=" + dob + ", gender=" + gender
				+ ", creditScore=" + creditScore + "]";
	}
	
	
}

