package com.mybank.model;

import java.util.Date;

public class Transactions {

	private int transaction_id;
	private int account_id;
	private int customer_id;
	private String transaction;
	private double amount;
	private double balance;
	private Date date;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
		return "Transactions [transaction_id=" + transaction_id + ", account_id=" + account_id + ", customer_id="
				+ customer_id + ", transaction=" + transaction + ", amount=" + amount + ", balance=" + balance
				+ ", date=" + date + "]";
	}
	
}
