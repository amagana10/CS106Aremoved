package com.MeritAmericaBank.app;

import java.util.Arrays;

public class AccountHolder {
	private static final int MAX_ELEMENT = 100;

	private static final int MAX_BALANCE_LIMIT = 250000;

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;

	private int numberOfCheckingAccounts = 0;
	private int numberOfSavingsAccounts = 0;
	private int numberOfCDAccounts = 0;

	private CheckingAccount[] checkingAccounts = new CheckingAccount[MAX_ELEMENT];
	private SavingsAccount[] savingsAccounts = new SavingsAccount[MAX_ELEMENT];
	private CDAccount[] cdAccounts = new CDAccount[MAX_ELEMENT];

	private double CDBalance;

	public AccountHolder() {

	}

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
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

	private boolean isSavingAndCheckingAccountCombinedBalanceLessThanTheLimit(double openingBalance) {
		return (openingBalance + getCheckingBalance() + getSavingsBalance()) < MAX_BALANCE_LIMIT;
	}

	public CheckingAccount addCheckingAccount(double openingBalance) {

		if (isSavingAndCheckingAccountCombinedBalanceLessThanTheLimit(openingBalance)) {

			numberOfCheckingAccounts++;

			if (numberOfCheckingAccounts > checkingAccounts.length) {

				CheckingAccount[] checkingAccountsTemp = Arrays.copyOf(checkingAccounts, checkingAccounts.length * 2);

				checkingAccounts = checkingAccountsTemp;

			}
			checkingAccounts[numberOfCheckingAccounts - 1] = new CheckingAccount(openingBalance);

			return checkingAccounts[numberOfCheckingAccounts - 1];

		}

		return null;

	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		return addCheckingAccount(checkingAccount.getBalance());
	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		return numberOfCheckingAccounts;
	}

	public double getCheckingBalance() {
		double totalCheckingAccountBalance = 0.0;

		for (int i = 0; i < numberOfCheckingAccounts; i++) {
			totalCheckingAccountBalance += checkingAccounts[i].getBalance();
		}

		return totalCheckingAccountBalance;
	}

	public SavingsAccount addSavingsAccount(double openingBalance) {

		if (isSavingAndCheckingAccountCombinedBalanceLessThanTheLimit(openingBalance)) {

			++numberOfSavingsAccounts;

			if (numberOfSavingsAccounts > savingsAccounts.length) {

				SavingsAccount[] savingsAccountsTemp = Arrays.copyOf(savingsAccounts, savingsAccounts.length * 2);

				savingsAccounts = savingsAccountsTemp;

			}
			savingsAccounts[numberOfSavingsAccounts - 1] = new SavingsAccount(openingBalance);

			return savingsAccounts[numberOfSavingsAccounts - 1];

		}

		return null;

	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		return addSavingsAccount(savingsAccount.getBalance());
	}

	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}

	public int getNumberOfSavingsAccounts() {
		return numberOfSavingsAccounts;
	}

	public SavingsAccount[] getSavingAccounts() {
		return savingsAccounts;
	}
	
	public double getSavingsBalance() {
		double totalSavingsAccountBalance = 0.0;

		for (int i = 0; i < numberOfSavingsAccounts; i++) {
			totalSavingsAccountBalance += savingsAccounts[i].getBalance();
		}

		return totalSavingsAccountBalance;
	}
	
	public double getCombinedBalance() {
		return getCheckingBalance()+getSavingsBalance();
	}
	
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		numberOfCDAccounts++;

		if (numberOfCDAccounts > cdAccounts.length) {

			CDAccount[] cdAccountsTemp = Arrays.copyOf(cdAccounts, cdAccounts.length * 2);

			cdAccounts = cdAccountsTemp;

		}
		
		cdAccounts[numberOfCDAccounts - 1] = new CDAccount(offering,openingBalance);

		return cdAccounts[numberOfCDAccounts - 1];
	}
 
	public CDAccount addCDAccount(CDAccount cdAccounts) {
		
		return addCDAccount(CDOffering.cdAccount());
		
	}
	
	public double getCDBalance() {
		
		return CDBalance;
	}
	
	public CDAccount[] getCDAccounts() {
		return cdAccounts;
	}
	
	public int getNumberOCDAccounts() {
		return numberOfCDAccounts;
	}
	
	
}
