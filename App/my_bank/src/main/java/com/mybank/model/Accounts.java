package com.mybank.model;

public class Accounts {

	private int accountId;
	private String accountType;
	private double balance;
	private int lowBalanceAlert;
	private int expenseAlert;
	private int customerId;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(int accountId, String accountType, double balance, int lowBalanceAlert,
			int expenseAlert, int customerId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.lowBalanceAlert = lowBalanceAlert;
		this.expenseAlert = expenseAlert;
		this.customerId = customerId;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", lowBalanceAlert=" + lowBalanceAlert + ", expenseAlert=" + expenseAlert + ", customerId="
				+ customerId + "]";
	}
	
}
