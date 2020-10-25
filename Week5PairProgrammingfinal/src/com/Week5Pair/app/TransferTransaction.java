package com.Week5Pair.app;

import java.util.Date;

public class TransferTransaction extends Transaction {

	TransferTransaction(String[] stringArray) {
		super();
	}

	TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.TargetAccount = targetAccount;
		this.amount = amount;
		this.transactionDate = new Date();
	}

}
