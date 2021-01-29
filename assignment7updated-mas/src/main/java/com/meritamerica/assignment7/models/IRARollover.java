package com.meritamerica.assignment7.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rollover")
public class IRARollover extends BankAccount{
	
//	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//	private int term;
	
}
