package com.Week5Pair.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount {
	static double interest = 0.0001;

	CheckingAccount(double openingBalance, double interest2) {
		super(openingBalance, interest);
	}

	public CheckingAccount(long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
	}

	public boolean withdraw(double amount) {
		if (amount <= super.getBalance() && amount > 0) {
			this.balance = balance - amount;
			return true;
		}
		return false;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			return true;
		}
		return false;
	}

	public String toString() {
		return "test String " + getBalance() + " " + getInterestRate() + " " + /* futureValue(years) */ futureValue(3);
	}

	public CheckingAccount(Long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public static CheckingAccount readFromString(String accountData) throws ParseException {

		String[] testName = accountData.split(",");

		long accountNumber = Long.parseLong(testName[0]);
		double balance = Double.parseDouble(testName[1]);
		double interestRate = Double.parseDouble(testName[2]);
		Date accountOpenedOn = formatter.parse(testName[3]);
		CheckingAccount newCheckingAccount = new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn);
		return newCheckingAccount;
	}
}
