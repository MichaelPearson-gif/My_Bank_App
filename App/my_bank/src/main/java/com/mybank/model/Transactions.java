package com.mybank.model;

import java.util.Date;

public class Transactions {

	private int transactionId;
	private int accountId;
	private String transaction;
	private double amount;
	private Date date;
	private String status;
	private String userId;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, int accountId, String transaction, double amount, Date date, String status,
			String userId) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transaction = transaction;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.userId = userId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountId=" + accountId + ", transaction="
				+ transaction + ", amount=" + amount + ", date=" + date + ", status=" + status + ", userId=" + userId
				+ "]";
	}
	
}
