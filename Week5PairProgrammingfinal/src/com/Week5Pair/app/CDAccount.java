package com.Week5Pair.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {
	Date date;
	private int term;
	CDOffering offering;

	public CDAccount(long accountNumber, Date accountOpenedOn, double balance, double interestRate, int term) {
		super(balance, interestRate, accountOpenedOn);
		this.balance = balance;
		this.term = term;

	}

	public CDAccount(CDOffering offering, double openingBalance) {
		super(openingBalance, offering.getInterestRate());
		this.offering = offering;
		this.term = offering.getTerm();
	}

	public CDAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn, int term) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
		this.term = term;
	}

	public int getTerm() {
		return this.term;
	}

	public Date getStartDate() {
		return date;
	}

	public double futureValue() {
		return super.futureValue(term);
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}

	public boolean deposit(double amount) {
		return false;
	}

	public static CDAccount readFromString(String accountData) throws ParseException, NumberFormatException {

		String[] testName = accountData.split(",");
		SimpleDateFormat daate = new SimpleDateFormat("dd/MM/yyyy");
		long accountNumber = Long.parseLong(testName[0]);
		double balance = Double.parseDouble(testName[1]);
		double interestRate = Double.parseDouble(testName[2]);
		Date accountOpenedOn = daate.parse(testName[3]);
		int term = Integer.parseInt(testName[4]);

		CDAccount newCDAccount = new CDAccount(accountNumber, balance, interestRate, accountOpenedOn,
				term /* offering */);
		return newCDAccount;
	}

	public String writeToString() {
		StringBuilder stringOverRide = new StringBuilder();
		stringOverRide.append(writeToString()).append(",");
		stringOverRide.append(term);
		return stringOverRide.toString();
	}

}
