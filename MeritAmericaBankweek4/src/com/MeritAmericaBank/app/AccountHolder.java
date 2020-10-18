package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountHolder implements Comparable<AccountHolder> {
	private static final String AccountHolder = null;
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private double checkingAccountOpeningBalance;
	private double savingsAccountOpeningBalance;

	public AccountHolder() {

	}

	public AccountHolder(String firstName, String middleName, String lastName, String ssn,
			double checkingAccountOpeningBalance, double savingsAccountOpeningBalance) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.checkingAccountOpeningBalance = checkingAccountOpeningBalance;
		this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
	}
      
	List<AccountHolder> ah1 = new ArrayList<AccountHolder>();
	
	public int compareTo(AccountHolder otherAccountHolder) {
		return (this.getCombinedBalance()).compareTo(otherAccountHolder.getCombinedBalance());
		Collections.sort(ah1);
	}
	
	static AccountHolder readFromString(String accountHolderData) throws ParseException {
		if (accountHolderData.equals(null))
			throw new java.lang.NumberFormatException(null);
		return null;
		
	}
	
	private Reader getAccountHolders;
	private String name;
	private String line;
	private double SavingsAccount;
	private double CheckingAccount;
	{
		BufferedReader br = new BufferedReader(new FileReader(name));
		br.readLine();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br.readLine()) != null)

			PrintWriter.println(line);

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public String getSSN() {
		return ssn;
	}

	public CheckingAccount getCheckingAccount() {
		return CheckingAccount(checkingAccountOpeningBalance);
	}

	CheckingAccount CheckingAccount(double checkingAccountOpeningBalance2) {

		return null;
	}

	public SavingsAccount getSavingAccount() {
		return SavingAccount(savingsAccountOpeningBalance);
	}

	private SavingsAccount SavingAccount(double savingsAccountOpeningBalance2) {

		return null;
	}

	public String toString() {
		return firstName;

	}

	public void addSavingsAccount(double d) {
		SavingsAccount++;
		
	}

	public String getCombinedBalance() {
		
		return getCombinedBalance();
	}

	public String getCheckingBalance() {
		
		return getCheckingBalance();

}

	public String getSavingsBalance() {
	
		return getSavingsBalance();
	}

	public void addCDAccount(CDOffering bestCDOffering, int i) {
		
		
	}

	public void addSavingsAccount(com.MeritAmericaBank.app.SavingsAccount savingsAccountOne) {
	SavingsAccount++;
		
	}

	public void addCheckingAccount(com.MeritAmericaBank.app.CheckingAccount checkingAccountOne) {
		CheckingAccount++;
		
	}