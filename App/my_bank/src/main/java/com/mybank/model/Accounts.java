package com.mybank.model;

public class Accounts {

	private int accountId;
	private String accountType;
	private double balance;
	private int lowBalanceAlert;
	private int expenseAlert;
	private String userId;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(int accountId, String accountType, double balance, int lowBalanceAlert, int expenseAlert,
			String userId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.lowBalanceAlert = lowBalanceAlert;
		this.expenseAlert = expenseAlert;
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getLowBalanceAlert() {
		return lowBalanceAlert;
	}

	public void setLowBalanceAlert(int lowBalanceAlert) {
		this.lowBalanceAlert = lowBalanceAlert;
	}

	public int getExpenseAlert() {
		return expenseAlert;
	}

	public void setExpenseAlert(int expenseAlert) {
		this.expenseAlert = expenseAlert;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	// Overriding hashCode and equals methods to ensure that two objects are equal to one another
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + expenseAlert;
		result = prime * result + lowBalanceAlert;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (expenseAlert != other.expenseAlert)
			return false;
		if (lowBalanceAlert != other.lowBalanceAlert)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", lowBalanceAlert=" + lowBalanceAlert + ", expenseAlert=" + expenseAlert + ", userId=" + userId
				+ "]";
	}

	
	
}
