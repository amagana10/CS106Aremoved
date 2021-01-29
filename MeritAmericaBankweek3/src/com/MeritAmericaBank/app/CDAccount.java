package com.MeritAmericaBank.app;

import java.util.Date;

public class CDAccount extends BankAccount {

	private Date startDate;
	private CDOffering offering;

	public CDAccount(CDOffering offering, double balance) {
		super(System.currentTimeMillis(), balance, offering.getInterestRate());

		this.offering = offering;
		this.startDate = new Date();
	}

	public double getInteresetRate() {
		return offering.getInterestRate();
	}

	public int getTerm() {
		return offering.getTerm();
	}

	public Date getStartDate() {
		return startDate;
	}

	public CDOffering getOffering() {
		return offering;
	}

	public void setOffering(CDOffering offering) {
		this.offering = offering;
	}
}
