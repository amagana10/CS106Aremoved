package com.Week5Pair.app;

public class NegativeAmountException extends Exception {

	
	boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			return true;
		} else
			return Status.setText("Insuffiecient Funds - withdraw cancelled");
	}

//	NegativeAmountException(String errorMessage){
//		
//		super(errorMessage);
//	}
	private double balance;
	
}

