package com.MeritAmericaBank.app;

public class BankAccount {

	private double interestRate;
	private long accountNumber;
	private double balance;
	private double futureBalance;
	private double openingBalance;

	public BankAccount(double openingAmount, double interestRate) {
		this.balance = openingAmount;
		this.interestRate = interestRate;
		this.openingBalance = openingAmount;
	}

	public BankAccount(long accountNumber, double openingAmount, double interestRate) {
		
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = openingAmount;
		this.interestRate = interestRate;
		this.openingBalance = openingAmount;
	}

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
