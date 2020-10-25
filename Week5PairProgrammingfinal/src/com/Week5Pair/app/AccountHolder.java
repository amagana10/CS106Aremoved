package com.Week5Pair.app;

public class AccountHolder implements Comparable<AccountHolder> {
	private static final double MAX_BALANCE = 250000;
	String firstName;
	String middleName;
	String lastName;
	String ssn;
	CheckingAccount[] addedCheckingAccounts = new CheckingAccount[0];
	SavingsAccount[] addedsavingsAccounts = new SavingsAccount[0];
	CDAccount[] addedCDAccounts = new CDAccount[0];
	private BankAccount checkingAccount;

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSSN() {
		return ssn;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public CheckingAccount addCheckingAccount(double openingBalance)
			throws ExceedsFraudSuspicionLimitException, NegativeAmountException, ExceedsCombinedBalanceLimitException {
		if (getCheckingBalance() + getSavingsBalance() + openingBalance >= MAX_BALANCE) {

			throw new ExceedsCombinedBalanceLimitException();

		}

		DepositTransaction transaction = new DepositTransaction(addCheckingAccount(100.5),
				checkingAccount.getBalance());
		try {
			MeritBank.processTransaction(transaction);
		} catch (NegativeAmountException exception) {
			throw new NegativeAmountException();
		} catch (ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException(" should be checked");
		} catch (Exception exception) {

		}
		CheckingAccount newAccount = new CheckingAccount(openingBalance, CheckingAccount.interest);
		CheckingAccount[] testChecking = new CheckingAccount[addedCheckingAccounts.length + 1];
		for (int i = 0; i < testChecking.length - 1; i++) {
			testChecking[i] = addedCheckingAccounts[i];
		}
		addedCheckingAccounts = testChecking;
		addedCheckingAccounts[addedCheckingAccounts.length - 1] = newAccount;
		return newAccount;
	}

	public boolean addCheckingAccount(CheckingAccount checkingAccount) {
		try {
			if (checkingAccount.getBalance() + getCheckingBalance() + getSavingsBalance() >= MAX_BALANCE) {
				return false;
			}
			CheckingAccount[] testChecking = new CheckingAccount[addedCheckingAccounts.length + 1];
			for (int i = 0; i < testChecking.length - 1; i++) {
				testChecking[i] = addedCheckingAccounts[i];
			}
			addedCheckingAccounts = testChecking;
			addedCheckingAccounts[addedCheckingAccounts.length - 1] = checkingAccount;
			return checkingAccount != null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null != null;
		}
	}

	public CheckingAccount[] getCheckingAccounts() {
		return addedCheckingAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		int numberOfCheckingAccounts = addedCheckingAccounts.length;
		return numberOfCheckingAccounts;
	}

	public double getCheckingBalance() {
		double checkingBalance = 0;

		for (int i = 0; i < addedCheckingAccounts.length; i++) {
			checkingBalance = addedCheckingAccounts[i].getBalance() + checkingBalance;
		}
		return checkingBalance;
	}

	public SavingsAccount addSavingsAccount(double openingBalance)
			throws ExceedsFraudSuspicionLimitException, NegativeAmountException, ExceedsCombinedBalanceLimitException {
		if (getSavingsBalance() + getCheckingBalance() + openingBalance >= MAX_BALANCE) {
			throw new ExceedsCombinedBalanceLimitException();
		}
		SavingsAccount newAccount = new SavingsAccount(openingBalance, SavingsAccount.interest);
		DepositTransaction transaction = new DepositTransaction(newAccount, openingBalance);
		try {
			MeritBank.processTransaction(transaction);
		} catch (NegativeAmountException exception) {
			throw new NegativeAmountException();
		} catch (ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds the limit");
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		SavingsAccount[] testsavings = new SavingsAccount[addedsavingsAccounts.length + 1];
		for (int i = 0; i < testsavings.length - 1; i++) {
			testsavings[i] = addedsavingsAccounts[i];
		}
		addedsavingsAccounts = testsavings;
		addedsavingsAccounts[addedsavingsAccounts.length - 1] = newAccount;
		return newAccount;
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount)
			throws ExceedsFraudSuspicionLimitException, NegativeAmountException, ExceedsCombinedBalanceLimitException {
		if (savingsAccount.getBalance() + getCheckingBalance() + getSavingsBalance() >= 250000) {
			throw new ExceedsCombinedBalanceLimitException();

		}
		DepositTransaction transaction = new DepositTransaction(savingsAccount, savingsAccount.getBalance());
		try {
			MeritBank.processTransaction(transaction);
		} catch (NegativeAmountException exception) {
			throw new NegativeAmountException();
		} catch (ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds the limit");
		} catch (Exception exception) {

		}

		SavingsAccount[] testsavings = new SavingsAccount[addedsavingsAccounts.length + 1];
		for (int i = 0; i < testsavings.length - 1; i++) {
			testsavings[i] = addedsavingsAccounts[i];
		}
		addedsavingsAccounts = testsavings;
		addedsavingsAccounts[addedsavingsAccounts.length - 1] = savingsAccount;
		return savingsAccount;
	}

	public double getSavingsBalance() {
		double total = 0.0;
		for (SavingsAccount balance : addedsavingsAccounts) {
			total += balance.getBalance();
		}
		return total;

	}

	public SavingsAccount[] getSavingsAccounts() {
		return addedsavingsAccounts;
	}

	public CDAccount addCDAccount(CDOffering offering, double openBalance)
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		CDAccount newAccount = new CDAccount(offering, openBalance);
		DepositTransaction transaction = new DepositTransaction(newAccount, openBalance);
		try {
			MeritBank.processTransaction(transaction);
		} catch (NegativeAmountException exception) {
			throw new NegativeAmountException();
		} catch (ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds the limit");
		} catch (Exception exception) {

		}

		CDAccount[] testcd = new CDAccount[addedCDAccounts.length + 1];
		for (int i = 0; i < testcd.length - 1; i++) {
			testcd[i] = addedCDAccounts[i];
		}
		addedCDAccounts = testcd;
		addedCDAccounts[addedCDAccounts.length - 1] = newAccount;
		return newAccount;
	}

	public CDAccount addCDAccount(CDAccount cdAccount)
			throws ExceedsFraudSuspicionLimitException, NegativeAmountException {

		DepositTransaction transaction = new DepositTransaction(cdAccount, cdAccount.getBalance());
		try {
			MeritBank.processTransaction(transaction);
		} catch (NegativeAmountException exception) {
			throw new NegativeAmountException();
		} catch (ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds the limit");
		} catch (Exception exception) {

		}
		CDAccount[] testcd = new CDAccount[addedCDAccounts.length + 1];
		for (int i = 0; i < testcd.length - 1; i++) {
			testcd[i] = addedCDAccounts[i];
		}
		addedCDAccounts = testcd;
		addedCDAccounts[addedCDAccounts.length - 1] = cdAccount;
		return cdAccount;
	}

	public CDAccount[] getCDAccounts() {
		return addedCDAccounts;
	}

	public int getNumberOfSavingsAccounts() {
		int numberOfSavingsAccounts = addedsavingsAccounts.length;
		return numberOfSavingsAccounts;
	}

	public int getNumberOfCDAccounts() {
		int amountCDAccounts = this.addedCDAccounts.length;
		return amountCDAccounts;
	}

	public double getCDBalance() {
		double total = 0.0;
		for (CDAccount balance : addedCDAccounts) {
			total += balance.getBalance();
		}
		return total;
	}

	public int compareTo(AccountHolder account) {
		if (this.getCombinedBalance() > account.getCombinedBalance()) {
			return 1;
		} else {
			return -1;
		}
	}

	public double getCombinedBalance() {
		double combo = getCDBalance() + getSavingsBalance() + getCheckingBalance();
		return combo;
	}

	public String writeToString() {
		StringBuilder accountHolderData = new StringBuilder();
		accountHolderData.append(firstName).append(",");
		accountHolderData.append(middleName).append(",");
		accountHolderData.append(lastName).append(",");
		accountHolderData.append(ssn);
		return accountHolderData.toString();
	}

	public static AccountHolder readFromString(String accountHolderData) {
		String[] testName = accountHolderData.split(",");
		String firstName = testName[0];
		String middleName = testName[1];
		String lastName = testName[2];
		String ssn = testName[3];
		return new AccountHolder(firstName, middleName, lastName, ssn);
	}

}
