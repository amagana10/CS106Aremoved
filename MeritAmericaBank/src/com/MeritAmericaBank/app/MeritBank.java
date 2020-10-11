package com.MeritAmericaBank.app;

public class MeritBank {

	private static final int MAX_ELEMENT = 200;

	private static AccountHolder[] accountHolders = new AccountHolder[MAX_ELEMENT]; // Temporary storage

	private static CDOffering[] cdOfferings = new CDOffering[MAX_ELEMENT];

	public static void addAccountHolder(AccountHolder accountHolder) {
		for (int i = 0; i < MAX_ELEMENT; i++) {
			if (accountHolders[i] == null) { // if the array at index is not occupied then put the account holder
				accountHolders[i] = accountHolder;

				break;
			}
		}

	}


	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

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

	public static double totalBalances() {
		return 123.03d;

	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue;
	}

}
