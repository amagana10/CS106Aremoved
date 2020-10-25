package com.Week5Pair.app;

import java.util.Date;

public class WithdrawTransaction extends Transaction {

	WithdrawTransaction(String[] stringArray) {
		super();

	}

	WithdrawTransaction(BankAccount targetAccount, double amount) {
		sourceAccount = targetAccount;
		this.TargetAccount = targetAccount;
		this.amount = amount;
		this.transactionDate = new Date();
	}
}
