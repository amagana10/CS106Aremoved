package com.meritamerica.assignment7.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
@Entity
@DiscriminatorValue("IRA")
public class IRAAccount extends BankAccount {

	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private int term;
	@NotNull(message = "Missing interestRate.")
	private double interestRate;
	
	public IRAAccount() {
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Date getStartDate() {
		Date date = new Date();
		return date;
	}

	@Override
	public boolean deposit(double amount) {
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}
}
