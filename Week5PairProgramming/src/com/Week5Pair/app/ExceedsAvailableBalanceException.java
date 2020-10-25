package com.Week5Pair.app;

public class ExceedsAvailableBalanceException extends Exception {

	private double balance;

	public double getBalance() {
		return balance;
	}

	boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			return true;
		} else
			return Status.setText("Insuffiecient Funds - withdraw cancelled");
	}

//	ExceedsAvailableBalanceException(String errorMessage) {
//		super(errorMessage);
//	}

}
