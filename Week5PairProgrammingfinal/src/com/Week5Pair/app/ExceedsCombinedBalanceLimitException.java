package com.Week5Pair.app;

public class ExceedsCombinedBalanceLimitException extends Exception {

	private static final int MAX_BALANCE_LIMIT = 250000;
	private double balance;

	public double getBalance() {
		return balance;
	}

	boolean deposit(double amount) {
		if (amount > 0 && MAX_BALANCE_LIMIT <= balance) {
			balance += amount;
			return true;
		} else
			return Status.setText("Exceeds the maximum limit");
	}
	
//	ExceedsCombinedBalanceLimitException(String errorMessage){
//		super(errorMessage);
//	}
}
