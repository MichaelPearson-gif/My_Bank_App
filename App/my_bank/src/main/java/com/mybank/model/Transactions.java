package com.mybank.model;

import java.util.Date;

public class Transactions {

	private int transactionId;
	private int accountId;
	private int customerId;
	private String transaction;
	private double amount;
	private double balance;
	private Date date;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, int accountId, int customerId, String transaction, double amount,
			double balance, Date date) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.customerId = customerId;
		this.transaction = transaction;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountId=" + accountId + ", customerId="
				+ customerId + ", transaction=" + transaction + ", amount=" + amount + ", balance=" + balance
				+ ", date=" + date + "]";
	}
	
}
