package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class CDOffering {

	private int term;
	private double interestRate;

	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
     CDOffering readFromString(String cdOfferingDataString) {
    	 if(cdOfferingDataString.equals(null))
    		 return null;
    	 
     }
     
	@Override
	public String toString() {
		return "CDOffering [term=" + term + ", interestRate=" + interestRate + "]";
	}

	private Reader description;
	private String line;
	private String file;

	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br.readLine()) != null)

			PrintWriter.println(line);
	}

	BufferedReader br = new BufferedReader(description);

	public String getLine() {
		return line;
	}

	public String getFile() {
		return file;
	}

	public int getTerm() {
		return term;
	}

	private Reader getTerm;
	BufferedReader tr = new BufferedReader(getTerm);

	public double getInterestRate() {
		return interestRate;

	}

	private Reader getInterestRate;
	BufferedReader in = new BufferedReader(getInterestRate);

	public static CDAccount cdAccount() {

		return cdAccount();
	}

}
