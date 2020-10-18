package com.MeritAmericaBank.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public abstract class MeritBank {

	private static final int MAX_ELEMENT = 200;

	private static AccountHolder[] accountHolders = new AccountHolder[MAX_ELEMENT];

	private static CDOffering[] cdOfferings = new CDOffering[MAX_ELEMENT];

	  static boolean readFromFile(String fileName) {
		return false;
	}
	 static  boolean writeToFile(String fileName) {
			return false;
		}
	 abstract void setNextAccountNumber(long nextAccountNumber);
	   
	   abstract AccountHolder[] sortAccountHolders();
	   
	public static  void addAccountHolder(AccountHolder accountHolder) {
		for (int i = 0; i < MAX_ELEMENT; i++) {
			if (accountHolders[i] == null) {
				accountHolders[i] = accountHolder;

				break;
			}
		}

	}

	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	private Reader getAccountHolders;

	private String file;
	private String line;
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br.readLine()) != null)

			PrintWriter.println(line);

	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

	private Reader getCDOfferings;

	{
		BufferedReader br1 = new BufferedReader(new FileReader(file));
		br1.readLine();
		BufferedReader stdin1 = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br1.readLine()) != null)

			PrintWriter.println(line);
	}

	BufferedReader br = new BufferedReader(getCDOfferings);

	public static CDOffering getBestCDOffering(double depositAmount) {
		return new CDOffering(1, 1.8);
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {

		return new CDOffering(2, 1.9);
	}

	public static void clearCDOfferings() {
		cdOfferings = new CDOffering[MAX_ELEMENT];
	}

	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}

	public static long getNextAccountNumber() {
		return Long.MAX_VALUE;
	}

	private Reader getNextAccountNumber;

	{
		BufferedReader br = new BufferedReader(new FileReader(file));
	          br.readLine();
	          BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	          
		while ((line = br.readLine())!= null)

//			PrintWriter.println(line);
	}

	BufferedReader an = new BufferedReader(getNextAccountNumber);

	public static double totalBalances() {
		return 123.03d;

	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue;
	}

}
