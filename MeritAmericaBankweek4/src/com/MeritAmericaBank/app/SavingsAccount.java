package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;

public class SavingsAccount extends BankAccount {

	private static final double INTEREST_RATE = 0.01;

	public SavingsAccount(double openingBalance) {
		super(openingBalance, INTEREST_RATE);
	}

	public SavingsAccount(double balance, Reader accountNumber, double currentBalalnce, Reader dateAccountOpened) {
		super(balance, 0.01);
		AccountNumber = accountNumber;
		CurrentBalalnce = currentBalalnce;
		this.dateAccountOpened = dateAccountOpened;
	}

	static CheckingAccount readFromString(String accountData) throws ParseException {
		if (accountData.equals(null))
			throw new java.lang.NumberFormatException(null);
		return null;
	}

	private Reader AccountNumber;
	private double CurrentBalalnce;
	BufferedReader an = new BufferedReader(AccountNumber, (int) CurrentBalalnce);

	Reader dateAccountOpened;
	BufferedReader date = new BufferedReader(dateAccountOpened);
	private String file;

	BufferedReader br = new BufferedReader(new FileReader(file));br.readLine();
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	while((line=br.readLine())!=null);

	PrintWriter.println(line);

}
