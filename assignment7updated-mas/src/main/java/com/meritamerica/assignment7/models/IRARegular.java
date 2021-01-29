package com.meritamerica.assignment7.models;

import java.text.SimpleDateFormat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Regular")
public class IRARegular extends BankAccount {

//	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//	private int term;
}
