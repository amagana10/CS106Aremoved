package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;
import java.util.Date;

public class CDAccount extends BankAccount {

	private Date startDate;
	private CDOffering offering;

	public CDAccount(CDOffering offering, double balance) {
		super(System.currentTimeMillis(),offering.getInterestRate());

		this.offering = offering;
		this.startDate = new Date();
	}
	
	
	public CDAccount(double balance, double interesetRate, Date startDate, CDOffering offering,
			Reader dateAccountOpened, BufferedReader date, Reader accountNumber,
			Reader getInteresetRate, Reader getTerm) {
		super(balance, interesetRate);
		this.startDate = startDate;
		this.offering = offering;
		this.dateAccountOpened = dateAccountOpened;
		AccountNumber = accountNumber;
		this.getInteresetRate = getInteresetRate;
		this.getTerm = getTerm;
	
	}

	@Override
	public String toString() {
		return "CDAccount [getTerm=" + getTerm + "]";
	}


	static CDAccount readFromString(String accountData) throws ParseException {
		
		if (accountData.equals(null))
			throw new java.lang.NumberFormatException(null);
		return null;
	}

	private Reader dateAccountOpened;
	BufferedReader date = new BufferedReader(dateAccountOpened);
	
	private Reader AccountNumber;
	BufferedReader an = new BufferedReader(AccountNumber);
	private String line;
	private String file;
	
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br.readLine()) != null)

			PrintWriter.println(line);
	}
	
	public double getInteresetRate() {
		return offering.getInterestRate();
	}

	private Reader getInteresetRate;
	BufferedReader in = new BufferedReader(getInteresetRate);
	
	
	public int getTerm() {
		return offering.getTerm();
	}
	
	private Reader getTerm;
	BufferedReader tr = new BufferedReader(getTerm);

	public Date getStartDate() {
		return startDate;
	}

	public CDOffering getOffering() {
		return offering;
	}

	public void setOffering(CDOffering offering) {
		this.offering = offering;
	}
}
