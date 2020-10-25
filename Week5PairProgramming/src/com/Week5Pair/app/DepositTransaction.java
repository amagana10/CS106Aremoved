package com.Week5Pair.app;

import java.util.Date;

public class DepositTransaction  extends Transaction{
	
public DepositTransaction(String[] stringArray) {
		super();
		
	}

DepositTransaction(BankAccount targetAccount, double amount){
	
		this.TargetAccount = targetAccount;
		this.amount = amount;
		this.transactionDate = new Date();
	}


}
