package com.Week5Pair.app;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.NumberFormatException;
public abstract class BankAccount {
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private static final double MAX_BALANCE = 250000;
	 Date accountOpenedOn;
	double balance;
	double interestRate;
	long accountNumber;
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
	    this.interestRate = interestRate;
	    this.accountOpenedOn = new Date();
	    this.accountNumber = MeritBank.getNextAccountNumber();
	}


	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	
	public List<Transaction> getTransactions(){
		return transactions;
	}
	BankAccount(double balance, double interestRate, Date accountOpenedOn){
		this(balance, interestRate);
		this.accountOpenedOn = accountOpenedOn;
	}
	    
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
		this(balance, interestRate, accountOpenedOn);
		this.accountNumber = accountNumber;
	}
	   

	public java.util.Date getOpenedOn() {

		return accountOpenedOn;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public boolean withdraw(double amount) {
		if(amount <= balance && amount > 0) {
			this.balance = balance - amount;
			return true;
		}
		return false;
	}
	public boolean deposit(double amount) {
		if (amount <= 0) {
	        return false;
	    } else {
	    	this.balance = balance + amount;
	    	return true;
	    }}

	public double futureValue(int years) {
		double futureVal = this.balance * Math.pow(1 + getInterestRate(), years);
		return futureVal;
	}

	static BankAccount readFromString(String accountData) throws ParseException, NumberFormatException {
		
		try {
			String[] testName = accountData.split(",");
			SimpleDateFormat daate = new SimpleDateFormat("dd/MM/yyyy");
			
			Long accountNumber = Long.parseLong(testName[0]);
	        double balance = Double.parseDouble(testName[1]);
	        double interestRate = Double.parseDouble(testName[2]);
	        Date accountOpenedOn = daate.parse(testName[3]);
	          BankAccount(accountNumber,balance,interestRate, accountOpenedOn);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}



	protected static BankAccount BankAccount(Long accountNumber2,double balance2, double interestRate2,Date accountOpenedOn2) {
		MeritBank.getNextAccountNumber(); 
		return null;
	}
	
	String writeToString() {
		StringBuilder accountData = new StringBuilder();
		accountData.append("account opened on ").append(accountOpenedOn);
		accountData.append("balance ").append(balance);
		accountData.append("interest rate ").append(interestRate);
		accountData.append("account number ").append(accountNumber);
		return accountData.toString();
	}
}
