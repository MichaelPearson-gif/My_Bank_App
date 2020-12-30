package com.app.model;

public class Accounts {

	private int accountId;
	private String accountType;
	private long routingId;
	private double balance;
	private int lowBalanceAlert;
	private int expenseAlert;
	private int customerId;
	private int employeeId;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(int accountId, String accountType, long routingId, double balance, int lowBalanceAlert,
			int expenseAlert, int customerId, int employeeId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.routingId = routingId;
		this.balance = balance;
		this.lowBalanceAlert = lowBalanceAlert;
		this.expenseAlert = expenseAlert;
		this.customerId = customerId;
		this.employeeId = employeeId;
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

	public long getRoutingId() {
		return routingId;
	}

	public void setRoutingId(long routingId) {
		this.routingId = routingId;
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", routingId=" + routingId
				+ ", balance=" + balance + ", lowBalanceAlert=" + lowBalanceAlert + ", expenseAlert=" + expenseAlert
				+ ", customerId=" + customerId + ", employeeId=" + employeeId + "]";
	}
	
	
}
