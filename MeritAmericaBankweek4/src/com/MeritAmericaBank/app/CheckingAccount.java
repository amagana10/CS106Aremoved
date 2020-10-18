package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;

public class CheckingAccount extends BankAccount {

	private static double INTEREST_RATE = 0.001;

	public CheckingAccount(double openingBalance) {
		super(openingBalance, INTEREST_RATE);
	}

	public CheckingAccount(double balance, Reader accountNumber, double currentBalalnce, Reader dateAccountOpened) {
		super(balance, 0.001);
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

	private Reader dateAccountOpened;
	BufferedReader date = new BufferedReader(dateAccountOpened);

	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	while((line=br.readLine())!=null)

	PrintWriter.println(line);

}
