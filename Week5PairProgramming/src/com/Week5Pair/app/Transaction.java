package com.Week5Pair.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public abstract class Transaction {

	BankAccount sourceAccount;
	BankAccount TargetAccount;
	static BankAccount source;
	double amount;
	Date transactionDate;
	String reason;

	// Transaction(String[] stringArray) {
//		
//	this.sourceAccount = stringArray //[0];
//		this.TargetAccount = BankAccount stringArray[1];
//		this.
//	}

//==========GETTERS/SETTERS===================

	public BankAccount getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public BankAccount getTargetAccount() {
		return TargetAccount;
	}

	public void setTargetAccount(BankAccount targetAccount) {
		TargetAccount = targetAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransActionDate() {
		return transactionDate;
	}

	public void setTransActionDate(Date transActionDate) {
		this.transactionDate = transActionDate;
	}

	public String getRejectionReason() {
		return reason;
	}

	public void setRejectionReason(String reason) {
		this.reason = reason;
	}

	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();

		if (sourceAccount == null) {
			sb.append(false);
		} else
			sb.append(sourceAccount.getAccountNumber());
		sb.append(",");
		sb.append(sourceAccount.getAccountNumber());
		sb.append(",");
		sb.append(amount);
		sb.append(",");
		sb.append(dateFormatter.format(transactionDate));
		return sb.toString();

	}

	public static Transaction readFromString(String transactionDataString) throws ParseException {
		String[] localArray = transactionDataString.split(",");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		long targetAccount = Long.parseLong(localArray[1]);
		double ammount = Double.parseDouble(transactionDataString);
		try {
			Date transationDate = formatter.parse(transactionDataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (localArray[0].equals("-1")) {
			source = null;
		} else {
			source = MeritBank.getBankAccount(Long.valueOf(localArray[0]));
		}
		return Transaction(localArray);
	}

	private static Transaction Transaction(String[] localArray) {
		if (localArray[0] != null)

			return null;

		else
			return Transaction(localArray);

	}

}
