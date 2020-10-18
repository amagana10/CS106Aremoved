package com.MeritAmericaBank.app;

import java.text.ParseException;
import java.util.Date;

public class BankAccount {

	private double interestRate;
	private long accountNumber;
	private double balance;
	private double futureBalance;
	private double openingBalance;

//	public BankAccount(double openingAmount, double interestRate) {
//		this.balance = openingAmount;
//		this.interestRate = interestRate;
//		this.openingBalance = openingAmount;
//	}

	public BankAccount(double balance, double interesetRate) {
		this.balance = balance;
		this.interestRate = interesetRate;

	}

	public BankAccount(double balance, double interesetRate, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interesetRate;
	}

	public BankAccount(long accountNumber, double balance, double interesetRate, java.util.Date accountOpenedOn) {

		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interesetRate;

	}

	java.util.Date getOpenedOn;

	static BankAccount readFromString(String accountData) throws ParseException {
		if (accountData.equals(null))
			throw new java.lang.NumberFormatException(null);
		return null;
	}

	String writeToString() {
		
	    return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ",interestRate" + interestRate + "]";
	}
	
	

//	public BankAccount(long accountNumber, double openingAmount, double interestRate) {
//		
//		this.accountNumber = MeritBank.getNextAccountNumber();
//		this.balance = openingAmount;
//		this.interestRate = interestRate;
//		this.openingBalance = openingAmount;
//	}

	public double getFutureBalance() {
		return futureBalance;
	}

	public long getAccountNumber() {
		return accountNumber;

	}

	public double getBalance() {
		return balance;

	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public boolean withdraw(double amount) {

		while (balance > amount && balance > 0) {

			balance -= amount;

			return true;

		}

		System.out.println("can't withdraw due to insuffient amount");

		return false;

	}

	public boolean deposit(double amount) {

		if (amount > 0) {

			balance += amount;
			return true;

		} else {
			System.out.println("invalid");

			return false;

		}
	}

	public double futureValue(int years) {
		futureBalance = balance * Math.pow(1.0 + interestRate, years);

		return futureBalance;

	}

}
